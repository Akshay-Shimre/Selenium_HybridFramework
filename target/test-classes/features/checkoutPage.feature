Feature: Search and Place order for Products

@PlaceOrder
Scenario Outline: Seacrh experiecnce of homepage and offerspage

Given : User is on GreenKart landing Page
When : user search with short name <Name> and extracted actual name of product
And : Added "3" items of selected product to cart
Then : User proceed to checkout and validate the <Name> items in checkout page
Then : Verify user has ability to enter promocode and place the order

Examples:
|Name|
| tom |

