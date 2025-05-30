# Deli-cious
A java command-line point-of-sale (POS) application for a custom sandwich shop-built using all 4 pillars of OOP (object-oriented programming). 

Customers can customize sandwiches, add drinks and chips, review orders, and generate receipts.


## Features

- Build Custom Sandwiches.
- Sizes: 4", 8", 12"
- Bread choices: white, wheat, rye, wrap, bagel, croissant.
- Add meats, cheeses, regular toppings, sauces.
- Extra meats, cheeses charged based on size.
- Toasted option.


- Add Drinks (small, medium, large)
- Add Chips (user-defined flavors)
- Checkout: Displays total and write receipt to 'receipt.csv'
- Cancel Order (inside checkout)

-----

## Object-Oriented Principles

| OOP Principle  | Implementation Example                                  |
|----------------|---------------------------------------------------------|
| **Encapsulation** | Private fields in 'Order', 'Sandwich', 'Topping' |
| **Abstraction** | 'Product interface and 'ReceiptFileManager' hide internal logic |
| **Inheritance** | 'Topping' -> 'RegularTop' and 'PremiumTop' subclasses |
| **Polymorphism** | 'Order' handles all 'Product' types (Sandwich, Drink, Chip) uniformly |

-----

## Class Structure

src/

|

 |------Main

 |------UserInterface

 |------Order

 |------ReceiptFileManager

|

Interface

 |------Product

 |------Sandwich

 |------Drink

 |------Chips
 
|

Abstract base class

|------Topping

|------RegularTop

|______PremiumTop