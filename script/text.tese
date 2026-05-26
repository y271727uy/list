#version 410 core

layout(vertices = 4) out;  // 输出4个控制点（四边形）

void main() {
    // 传递位置属性
    gl_out[gl_InvocationID].gl_Position = gl_in[gl_InvocationID].gl_Position;

    // 设置细分级别（内外均为2，分成2x2个小块）
    gl_TessLevelInner[0] = 2.0;
    gl_TessLevelInner[1] = 2.0;
    gl_TessLevelOuter[0] = 2.0;
    gl_TessLevelOuter[1] = 2.0;
    gl_TessLevelOuter[2] = 2.0;
    gl_TessLevelOuter[3] = 2.0;
}