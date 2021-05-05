#include <stdio.h>
#include <unistd.h>

const int cols = 16;

int main() {
    u_int8_t buf[cols];
    _ssize_t num_read;
    while ((num_read = read(STDIN_FILENO, buf, cols)) > 0) {
        int i;
        for (i = 0; i < num_read; i++) {
            printf("%02X ", buf[i]);
        }
        printf("%*c", (cols - num_read) * 3 + 2, ' ');
        for (i = 0; i < num_read; i++) {
            if (buf[i] < 0x20 || buf[i] > 0x7E) {
                printf(".");
            } else {
                printf("%c", (char)buf[i]);
            }
        }
        printf("\n");
    }
}