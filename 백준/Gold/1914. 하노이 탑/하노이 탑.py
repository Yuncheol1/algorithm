def hanoi(num, h_from, temp, to):
    if num == 1:
        print('%d %d' % (h_from, to))
    else:
        hanoi(num-1, h_from, to, temp)
        print('%d %d' % (h_from, to))
        hanoi(num-1, temp, h_from, to)


a = int(input())
times = 2**a - 1
print(times)
if a <= 20:
    hanoi(a, 1, 2, 3)