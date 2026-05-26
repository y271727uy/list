package com.list.util;

/**
 * 通用颜色工具类。
 * <p>
 * 只提供基础的 ARGB/RGB 拆装、透明度处理、夹取、线性插值与简单混色。
 * 不包含色彩空间转换、注册逻辑或业务专用规则。
 */
@SuppressWarnings("unused")
public final class CommonColor {

    private CommonColor() {
    }

    public static int clamp255(int value) {
        return Math.max(0, Math.min(255, value));
    }

    public static float clamp01(float value) {
        return Math.max(0.0F, Math.min(1.0F, value));
    }

    public static int alpha(int color) {
        return (color >>> 24) & 0xFF;
    }

    public static int red(int color) {
        return (color >>> 16) & 0xFF;
    }

    public static int green(int color) {
        return (color >>> 8) & 0xFF;
    }

    public static int blue(int color) {
        return color & 0xFF;
    }

    public static int argb(int alpha, int red, int green, int blue) {
        return (clamp255(alpha) << 24)
                | (clamp255(red) << 16)
                | (clamp255(green) << 8)
                | clamp255(blue);
    }

    public static int rgb(int red, int green, int blue) {
        return argb(255, red, green, blue);
    }

    public static int opaque(int color) {
        return 0xFF000000 | (color & 0x00FFFFFF);
    }

    public static int withAlpha(int color, int alpha) {
        return (clamp255(alpha) << 24) | (color & 0x00FFFFFF);
    }

    public static int multiply(int left, int right) {
        return argb(
                multiplyChannel(alpha(left), alpha(right)),
                multiplyChannel(red(left), red(right)),
                multiplyChannel(green(left), green(right)),
                multiplyChannel(blue(left), blue(right))
        );
    }

    public static int lerp(int start, int end, float t) {
        float ratio = clamp01(t);
        return argb(
                lerpChannel(alpha(start), alpha(end), ratio),
                lerpChannel(red(start), red(end), ratio),
                lerpChannel(green(start), green(end), ratio),
                lerpChannel(blue(start), blue(end), ratio)
        );
    }

    public static int mix(int first, int second, float ratio) {
        return lerp(first, second, ratio);
    }

    public static int average(int first, int second) {
        return mix(first, second, 0.5F);
    }

    public static int scaleRgb(int color, float factor) {
        float scaled = Math.max(0.0F, factor);
        return argb(
                alpha(color),
                scaleChannel(red(color), scaled),
                scaleChannel(green(color), scaled),
                scaleChannel(blue(color), scaled)
        );
    }

    private static int multiplyChannel(int left, int right) {
        return clamp255((left * right + 127) / 255);
    }

    private static int lerpChannel(int start, int end, float t) {
        return clamp255(Math.round(start + (end - start) * t));
    }

    private static int scaleChannel(int channel, float factor) {
        return clamp255(Math.round(channel * factor));
    }
}


