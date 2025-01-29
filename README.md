# Reward-Program

This Spring Boot application calculates and provides rewards points for customers based on their purchase transactions over a dynamic time period (e.g., monthly, 3 months). The reward system awards points based on the following criteria:

2 points for every dollar spent over $100 in a transaction.
1 point for every dollar spent between $50 and $100 in each transaction.
The goal of this project is to create an API endpoint that calculates the reward points for a given customer, based on the transactions within a selected time frame.

**Features**
Rewards Calculation: Customers earn points based on their transaction amounts.
Dynamic Time Frame: API allows for Monthly time frame selection.
Customer and Transaction Details: API response includes important information about customers and their transactions values for each month.
RESTful API: Exposes a RESTful API to calculate and retrieve reward points.


 **Endpoints** http://localhost:8080/reward
 **Sample Rquest**
{
  "customerId": 1343,
  "customerName": "mukul maurys",
  "rewards": {
    "firstMonth": 1320,
    "secondMonth": 90,
    "thirdMonth": 200
  }
}
**Sample Response**
{
    "customerId": 1343,
    "customerName": "mukul maurys",
    "rewardMonthwise": {
        "firstMonth": 2490,
        "secondMonth": 40,
        "thirdMonth": 250
    },
    "totalReward": 2780
}
