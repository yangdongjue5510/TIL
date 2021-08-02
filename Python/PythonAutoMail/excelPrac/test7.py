from openpyxl import load_workbook

wb = load_workbook('simpledata.xlsx') #classfy excel file
data = wb.active #active method contains excel sheet.

print(data['A1'].value)
print(data['A2'].value)
print(data['B1'].value)
print(data['B2'].value)
print()

row = data['2']
for cell in row:
    print(cell.value)

print()

col = data['A']
for cell in col:
    print(cell.value)