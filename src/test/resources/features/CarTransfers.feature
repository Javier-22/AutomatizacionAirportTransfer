Feature: The user wants the best deals to make an airport transfer
  @stories
  Scenario: Airport Transfers
    Given the user has entered the emirates page airport transfer section
      Then the user enters a pick-up location and a destination location:
      |  pick_up_location                         | pick_up_destination                | pick_up_date | pick_up_time | return_date | return_time | passenger|
      |  Dubai - Intl Airport - Terminal 3        | Dubai - Intl Airport - Terminal 2  |  20/03/2022  | 6:00 PM      | 28/03/2022   | 10:00 AM   |     4    |
      And the user chooses any car
      And the user fill data in details and click into go to checkout with next data
      | name             | email              | confirm_email    | country_code | phone      | pick_up_number | return_number |
      |  Jose Ramirez    | jr@gmail.com       | jr@gmail.com     | +57          | 3216549877 | AB123          | BA321         |
      And the user fill data in payment with next data
      | card_number      | name         | month | year | cvc |
      | 4646364646464646 | Jose Ramirez | 03    | 2024 | 123 |
      When the user must see the pay secured button ready
