# CineSphere AI: Actor Career Analysis System

A Java Swing desktop application that analyses an actor's film career and produces career statistics, a 100-point career score and a rule-based career insight.

## Features
- Search for an actor and open a career dashboard
- Calculates total movies, average rating, total awards and the highest-rated movie
- Career score out of 100 using a weighted formula: rating (up to 50 points), awards (up to 30) and number of films (up to 20)
- Career verdict in four tiers: Emerging, Growing, Strong and Highly Successful
- Rule-based career insight generated from the calculated statistics (this is not a machine-learning model)
- Dark, cinematic interface with a Home screen and a Results screen, and navigation back to search so another actor can be analysed without restarting
- Input validation for empty or unknown actor names

## Screenshots
![Home screen](‎screenshots/Screenshot 2026-11-21 215055.png)
![Results screen](‎screenshots/Screenshot 2026-11-21 215055.png)

## Tech Stack
Java, Java Swing, Apache NetBeans, Maven

## Programming Concepts Used
Classes and objects, constructors, encapsulation (private fields with getters), ArrayList, loops, conditional statements, event handling and separation of data, logic and interface classes.

## Project Structure
| Class | Purpose |
| --- | --- |
| `Movie` | Stores movie name, role, genre, rating, release year and awards |
| `Actor` | Stores an actor's name and an ArrayList of movies |
| `ActorDatabase` | Holds the sample actor and movie data and searches by actor name |
| `CareerAnalyzer` | Calculates statistics, career score, verdict and rule-based insight |
| `HomeScreen` | Search screen |
| `ResultsScreen` | Career dashboard |
| `CineSphereAI` | Main class that launches the application |

## Sample Data
The app includes 5 sample actors (Shah Rukh Khan, Deepika Padukone, Aamir Khan, Leonardo DiCaprio and Tom Hanks), each with 3 featured films. The dataset was compiled manually for demonstration. Ratings and award counts are approximate and may not match official sources.

## Limitations
- The dataset is a small sample, so scores reflect only the featured films, not an actor's full career.
- The career score is a simple weighted formula designed for demonstration.
- The "AI" insight is rule-based (if/else logic on the statistics), not machine learning.

## Planned Improvements
- Expand the dataset with more films per actor
- Add a dropdown or autocomplete for actor selection
- Show data sources for ratings and awards

## How to Run
1. Open the project in Apache NetBeans
2. Run `CineSphereAI.java`

## Author
**Thendral K** | [GitHub](https://github.com/thendral1712) | [LinkedIn](https://www.linkedin.com/in/thendral-k-9a6515376/)
