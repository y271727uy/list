package com.list.util;

/**
 * 简单的色彩空间工具：把基准色与灰度明度结合，再按 XYZ / xyY 思路回算到 RGB。
 * <p>
 * 说明：Minecraft 物品 tint 仍然是整层颜色，不是逐像素重绘。
 * 这里的“XYZ 原理”用于把灰度明度映射为更自然的亮度变化。
 */
public final class ColorSpaceUtil {

    private static final double EPSILON = 1.0E-6;

    private ColorSpaceUtil() {
    }

    /**
     * 将一个基准 ARGB 色值按灰度明度进行 XYZ 风格调色。
     * <p>
     * grayLevel 建议范围 0~1：0 表示纯黑/最暗，1 表示完整保留基准色的亮度层次。
     *
     * @param baseArgb  基准颜色（ARGB）
     * @param grayLevel 灰度明度（0~1）
     * @return 调整后的 ARGB 颜色
     */
    @SuppressWarnings("unused")
    public static int tintFromGray(int baseArgb, float grayLevel) {
        float clampedGray = clamp01(grayLevel);

        int alpha = (baseArgb >>> 24) & 0xFF;
        int red = (baseArgb >>> 16) & 0xFF;
        int green = (baseArgb >>> 8) & 0xFF;
        int blue = baseArgb & 0xFF;

        double r = srgbToLinear(red / 255.0D);
        double g = srgbToLinear(green / 255.0D);
        double b = srgbToLinear(blue / 255.0D);

        // RGB -> XYZ (D65, 0~1 范围)
        double x = 0.4124564D * r + 0.3575761D * g + 0.1804375D * b;
        double y = 0.2126729D * r + 0.7151522D * g + 0.0721750D * b;
        double z = 0.0193339D * r + 0.1191920D * g + 0.9503041D * b;

        double sum = x + y + z;
        if (sum <= EPSILON) {
            return argb(alpha, 0, 0, 0);
        }

        double chromaX = x / sum;
        double chromaY = y / sum;
        double chromaZ = z / sum;

        // 让灰度值控制 XYZ 空间中的亮度 Y，保持色度比例不变。
        if (chromaY <= EPSILON) {
            int gray = linearToSrgb8(clampedGray);
            return argb(alpha, gray, gray, gray);
        }

        double targetX = chromaX * clampedGray / chromaY;
        double targetZ = chromaZ * clampedGray / chromaY;

        // XYZ -> linear RGB
        double linearR = 3.2404542D * targetX - 1.5371385D * clampedGray - 0.4985314D * targetZ;
        double linearG = -0.9692660D * targetX + 1.8760108D * clampedGray + 0.0415560D * targetZ;
        double linearB = 0.0556434D * targetX - 0.2040259D * clampedGray + 1.0572252D * targetZ;

        return argb(alpha,
                linearToSrgb8(linearR),
                linearToSrgb8(linearG),
                linearToSrgb8(linearB));
    }

    /**
     * 仅标准化 alpha 为不透明，保留原始 RGB。
     *
     * @param baseArgb 基准颜色（ARGB）
     * @return 不透明 ARGB 颜色
     */
    @SuppressWarnings("unused")
    public static int normalizeOpaque(int baseArgb) {
        return 0xFF000000 | (baseArgb & 0x00FFFFFF);
    }

    private static float clamp01(float value) {
        if (value < 0.0F) {
            return 0.0F;
        }
        return Math.min(value, 1.0F);
    }

    private static double srgbToLinear(double value) {
        if (value <= 0.04045D) {
            return value / 12.92D;
        }
        return Math.pow((value + 0.055D) / 1.055D, 2.4D);
    }

    private static int linearToSrgb8(double value) {
        double clamped = clamp01((float) value);
        double srgb = clamped <= 0.0031308D
                ? clamped * 12.92D
                : 1.055D * Math.pow(clamped, 1.0D / 2.4D) - 0.055D;
        return (int) Math.round(Math.max(0.0D, Math.min(srgb, 1.0D)) * 255.0D);
    }

    private static int argb(int alpha, int red, int green, int blue) {
        return ((alpha & 0xFF) << 24)
                | ((red & 0xFF) << 16)
                | ((green & 0xFF) << 8)
                | (blue & 0xFF);
    }
}



