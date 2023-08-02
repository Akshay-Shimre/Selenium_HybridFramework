Feature: Search and Place order for Products

@OfferPage
Scenario Outline: Seacrh experiecnce of homepage and offerspage

Given : User is on GreenKart landing Page
When : user search with short name <Name> and extracted actual name of product
Then : user go and search  shortname <Name> on offerspage to chek if product exists
Then : Validate ProductPage Product and OfferPage product are equal
Examples:
|Name|
| tom |
|beet|

