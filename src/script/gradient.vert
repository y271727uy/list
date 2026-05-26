#version 330 core
in vec2 UV;
out vec4 FragColor;

uniform float u_Time;  // 从CPU传入的时间变量

void main() {
    // 红色随时间变化
    float r = sin(u_Time) * 0.5 + 0.5;
    // 绿色随UV的X变化
    float g = UV.x;
    // 蓝色随UV的Y变化
    float b = UV.y;

    FragColor = vec4(r, g, b, 1.0);
}