import sys

COL = 16


def main():
    while True:
        read = sys.stdin.buffer.read(COL)
        num_read = len(read)
        if num_read <= 0:
            break
        for c in read:
            print("%02X " % int(c), end="")
        print("%*c" % ((COL - num_read) * 3 + 2, ' '), end="")
        for c in read:
            i = int(c)
            if i < 0x20 or i > 0x7E:
                print(".", end="")
            else:
                print(chr(c), end="")
        print()


if __name__ == "__main__":
    main()