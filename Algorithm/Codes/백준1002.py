testCase = int(input())
for _ in range(testCase):
    x1, y1, dist1, x2, y2, dist2 = list(map(int, input().split()))

    minX = max(x1-dist1, x2-dist2)
    maxX = min(x1+dist1, x2+dist2)
    minY = max(y1-dist1, y2-dist2)
    maxY = min(y1+dist1, y2+dist2)
    count = 0
    for x in range(minX, maxX+1):
        for y in range(minY, maxY+1):
            if (x-x1)**2+(y-y1)**2 == dist1**2 and (x-x2)**2+(y-y2)**2 == dist2**2:
                count +=1
    print(count)
