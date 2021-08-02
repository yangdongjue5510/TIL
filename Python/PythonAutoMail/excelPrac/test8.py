from openpyxl import load_workbook

wb = load_workbook('simpledata.xlsx') #classfy excel file
data = wb['sheet_test'] #if want to select distinct sheet named 'sheet_test'

area = data['A1:B2']
for row in area:
    for cell in row:
        print(cell.value)

print()

cols = data['A:B']
for col in cols:
    print(col)
    for cell in col:
        print(cell.value)

print()

rows = data['1:2']
for row in rows:
    for cell in row:
        print(cell.value)