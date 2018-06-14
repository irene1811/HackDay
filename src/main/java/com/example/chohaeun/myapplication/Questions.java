package com.example.chohaeun.myapplication;

/**
 * Created by chohaeun on 6/13/18.
 */

public class Questions {

    public String mQuestions[] =
            {
                    "What is Data Visualization?",
                    "What is 'intranet'?",
                    "What does API stand for?",
                    "A corporation or other limited liability association that assumes and spreads the liability exposure for any of its group members is called:",
                    "If you get into a car accident, which type of insurance covers damages to the other vehicle?",
                    "Self-insurance is an example of what kind of risk treatment?",
                    "Which of the following would not be counted as part of incremental cash flow?",
                    "Volatility risk of a single asset is usually measured by which of the following?",
                    "What is logical regression?",
                    "What is a contribution margin?"

            };
    private String mChoices[][]={
            {"presenting large amounts of information in ways that are universally understandable or easy to interpret and spot patterns, trends and correlations","presenting large amounts of information in ways that are personally understandable or easy to interpret and spot patterns, trends and correlations","acts and statistics collected together for reference or analysis", "the representation of an object, situation, or set of information as a chart or other image"},
            {"Internal internet used to transfer information internally","Internal internet used to transfer information to the outside company", "Internal network designed to serve the internal informational needs of a single organization", "Internal network designed to transfer the information between two organizations"},
            {"Application Problem Interface", "Artificial Platform Intelligence", "Application Programming Interface", "Android Programming Interface"},
            {"A stock insurer","A risk retention group","A mutual insurer", "A reciprocal insurer"},
            {"Liability Insurance", "Automobile Insurance","Collision Insurance", "Health Insurance"},
            {"Transference", "Retention", "Avoidance", "Reduction"},
            {"Opportunity cost", "Sunk cost", "External cost such as brand cannibalism", "External benefit such as acquisition of new technology which can be applied to other projects"},
            {"Standard deviation", "Variance", "Correlation", "Covariance"},
            {"Statistical method of examining a dataset having one or more variables that are independent defining an outcome", "a return to a former or less developed state", "approach to modelling the relationship between a scalar response (or dependent variable) and one or more explanatory variables (or independent variables)", "a technique for analyzing multiple regression data that suffer from multicollinearity"},
            {"The amount of money that has been contributed to a project" ,"Gross profit", "Total money made","All associated variable costs"
            }
    };

    private String mAnswers[]={
            "presenting large amounts of information in ways that are universally understandable or easy to interpret and spot patterns, trends and correlations",
            "Internal network designed to serve the internal informational needs of a single organization",
            "Application Programming Interface",
            "A risk retention group",
            "Liability Insurance",
            "Retention",
            "Sunk cost",
            "Standard deviation",
            "Statistical method of examining a dataset having one or more variables that are independent defining an outcome",
            "Gross profit"
    };

    public String getQuestion(int a){
        return mQuestions[a];
    }

    public String getChoice1(int a){
        return mChoices[a][0];
    }

    public String getChoice2(int a){
        return mChoices[a][1];
    }

    public String getChoice3(int a){
        return mChoices[a][2];
    }

    public String getChoice4(int a){
        return mChoices[a][3];
    }

    public String getAnswer(int a){
        return mAnswers[a];
    }
}