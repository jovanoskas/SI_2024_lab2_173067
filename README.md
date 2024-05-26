# SI_2024_lab2_173067
Втора лабораториска вежба по Софтверско инженерство
Стефани Јованоска, бр. на индекс 173067

Група на код:
Ја добив групата на код 

Control Flow Graph

![CFG](https://github.com/jovanoskas/SI_2024_lab2_173067/assets/62565245/92222fda-5922-4465-a3f4-8fc6c69af8fb)


Цикломатска комплексност
Цикломатската комплексност на овој код е 13, истата ја добив преку формулата P+1, каде што P е бројот на предикатни јазли. 
Во случајoв P=12, па цикломатската комплексност изнесува 13.

Тест случаи според критериумот Every statement
....
Test Case 1: allItems is null

Input: allItems = null, payment = 100
Expected Output: Exception thrown with message "allItems list can't be null!"
Test Case 2: allItems is empty

Input: allItems = [], payment = 100
Expected Output: true (sum is 0 which is less than or equal to payment)
Test Case 3: item.getName() is null and item.getBarcode() is null

Input: allItems = [new Item(null, null, 100, 0)], payment = 100
Expected Output: Exception thrown with message "No barcode!"
Test Case 4: item.getName() is empty and item.getBarcode() is valid

Input: allItems = [new Item("", "123456", 100, 0)], payment = 100
Expected Output: true (sum is 100 which is less than or equal to payment)
Test Case 5: item.getName() is valid and item.getBarcode() is invalid

Input: allItems = [new Item("name", "12345a", 100, 0)], payment = 100
Expected Output: Exception thrown with message "Invalid character in item barcode!"
Test Case 6: item.getDiscount() > 0 and item.getBarcode() starts with '0'

Input: allItems = [new Item("name", "012345", 400, 0.1f)], payment = 100
Expected Output: false (sum is 40 which is less than 100, but it becomes 10 after deduction, so payment is less than sum)
Test Case 7: Multiple items with valid barcodes and discounts

Input: allItems = [new Item("name", "123456", 100, 0.2f), new Item("name", "234567", 200, 0)], payment = 300
Expected Output: true (sum is 20 + 200 = 220 which is less than 300)
Test Case 8: High price, discount, and starts with '0'

Input: allItems = [new Item("name", "012345", 400, 0.1f), new Item("name", "234567", 100, 0)], payment = 300
Expected Output: true (sum is 40 + 100 - 30 = 110 which is less than 300)


Тест случаи според критериумот Every path
....
Case 1: All conditions are true

item.getPrice() > 300: true
item.getDiscount() > 0: true
item.getBarcode().charAt(0) == '0': true
Input: allItems = [new Item("name", "012345", 400, 0.1f)], payment = 100
Expected Output: The condition is true, sum will be adjusted (deduct 30).
Case 2: Price > 300, Discount > 0, Barcode does not start with '0'

item.getPrice() > 300: true
item.getDiscount() > 0: true
item.getBarcode().charAt(0) == '0': false
Input: allItems = [new Item("name", "112345", 400, 0.1f)], payment = 100
Expected Output: The condition is false, sum will not be adjusted.
Case 3: Price > 300, Discount <= 0, Barcode starts with '0'

item.getPrice() > 300: true
item.getDiscount() > 0: false
item.getBarcode().charAt(0) == '0': true
Input: allItems = [new Item("name", "012345", 400, 0.0f)], payment = 100
Expected Output: The condition is false, sum will not be adjusted.
Case 4: Price > 300, Discount <= 0, Barcode does not start with '0'

item.getPrice() > 300: true
item.getDiscount() > 0: false
item.getBarcode().charAt(0) == '0': false
Input: allItems = [new Item("name", "112345", 400, 0.0f)], payment = 100
Expected Output: The condition is false, sum will not be adjusted.
Case 5: Price <= 300, Discount > 0, Barcode starts with '0'

item.getPrice() > 300: false
item.getDiscount() > 0: true
item.getBarcode().charAt(0) == '0': true
Input: allItems = [new Item("name", "012345", 300, 0.1f)], payment = 100
Expected Output: The condition is false, sum will not be adjusted.
Case 6: Price <= 300, Discount > 0, Barcode does not start with '0'

item.getPrice() > 300: false
item.getDiscount() > 0: true
item.getBarcode().charAt(0) == '0': false
Input: allItems = [new Item("name", "112345", 300, 0.1f)], payment = 100
Expected Output: The condition is false, sum will not be adjusted.
Case 7: Price <= 300, Discount <= 0, Barcode starts with '0'

item.getPrice() > 300: false
item.getDiscount() > 0: false
item.getBarcode().charAt(0) == '0': true
Input: allItems = [new Item("name", "012345", 300, 0.0f)], payment = 100
Expected Output: The condition is false, sum will not be adjusted.
Case 8: Price <= 300, Discount <= 0, Barcode does not start with '0'

item.getPrice() > 300: false
item.getDiscount() > 0: false
item.getBarcode().charAt(0) == '0': false
Input: allItems = [new Item("name", "112345", 300, 0.0f)], payment = 100
Expected Output: The condition is false, sum will not be adjusted.


Објаснување на напишаните unit tests
... ...
1. Every branch 
се осигурува дека секоја гранка на кодот се извршува барем еднаш. За checkCart() методот сакаме да се осигураме дека сите можни патеки низ методот се истестирани. Тоа го правиме со повеќе тест кејсес:
Test case 1: allItems is null.
Test case 2: allItems is empty.
Test case 3: item.getName() is null.
Test case 4: item.getName() is an empty string.
Test case 5: item.getName() is a valid string.
Test case 6: item.getBarcode() is null.
Test case 7: item.getBarcode() is a valid barcode.
Test case 8: Barcode contains valid characters.
Test case 9: Barcode contains invalid characters.
Test case 10: Item has a discount greater than 0.
Test case 11: Item has a discount equal to 0.
Test case 12: Price > 300, discount > 0, and barcode starts with '0'.
Test case 13: Multiple items with various conditions.
Test case 14: Sum is less than or equal to the payment.
Test case 15: Sum is greater than the payment.

2. Multiple Condition
Се фокусира на тестирање на секоја возможна комбинација на conditional statements.
Test case 1: price > 300, discount > 0, barcode starts with '0'.
Test case 2: price > 300, discount > 0, barcode does not start with '0'.
Test case 3: price > 300, discount <= 0, barcode starts with '0'.
Test case 4: price > 300, discount <= 0, barcode does not start with '0'.
Test case 5: price <= 300, discount > 0, barcode starts with '0'.
Test case 6: price <= 300, discount > 0, barcode does not start with '0'.
Test case 7: price <= 300, discount <= 0, barcode starts with '0'.
Test case 8: price <= 300, discount <= 0, barcode does not start with '0'.
