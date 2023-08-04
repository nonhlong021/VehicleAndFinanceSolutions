@finance
Feature: Monthly Repayments Calculation

  Scenario Outline: Calculate Monthly Repayments
    Given the user purchases a vehicle of price "<price>"
    And the deposit is "<deposit>"
    And the payment term is "<term>"
    And the balloon payment is "<balloon_percentage>"
    And the interest rate is "<interest>"
    Then the monthly repayment is "<monthly_repayment>"
    Examples:
      | price  | deposit | term | balloon_percentage | interest | monthly_repayment |
      | 900000 | 120000  | 54   | 20%                | 11       | 15884.34          |

#  Scenario: Calculate Cost of Finance
#    When the user wants to calculate the Cost of Finance
#    And the amount to finance is "<amount>"
#    And the interest amount is "interest_amount"
#    And the total cost of credit is "<total_cost>"

