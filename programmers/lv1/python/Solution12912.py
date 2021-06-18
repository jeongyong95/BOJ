def solution(a, b):
    answer = 0
    temp = 0
    if a > b:
        temp = b
        b = a
        a = temp

    for i in range(a, b+1):
        answer += i
    return answer
