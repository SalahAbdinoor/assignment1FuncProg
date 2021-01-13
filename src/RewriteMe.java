import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Inlämningsuppgit i kursen Funktionell Programmering för JAVA-programmet

För samtliga funktioner i denna fil, byt ut "throw UnSupportedException"-raden
och skriv ett pipeline-uttryck som returnerar det som ska returneras.

Streams MÅSTE användas i samtliga funktioner som lämnas in
För att testa om era funktioner funkar, kör testerna som hör till denna fil

För att bli godkänd på denna uppgift måste minst 7 av funktionerna vara implementerade.

Sigruns bedömning av denna uppgift kommer att gå till så att hon klipper in er version av denna fil
i sitt projekt och kör testerna.
Hennes kontroll om ni har klarat uppgifterna eller inte görs genom att
hon kollar att tillräckeligt många av tester går gröna. Pga detta ska ni inte ändra i någon fil
medföljande detta projekt, och inte heller metodsignaturerna i denna fil eller era tester, eftersom
ni då riskerar att påverka rättningen i negativ riktning.
 */

public class RewriteMe {
    
    public Database database = new Database();
    public List<Question> questions = database.getQuestions();
    
    //Skriv en funktioner som returnerar hur många frågor det finns i databasen?

    //1
    public int getAmountOfQuestionsInDatabase(){

        long amountOfQuestionsInDatabase = questions.stream().count();

        return (int) amountOfQuestionsInDatabase;
    }

    //Hur många frågor finns i databasen för en viss, given kategori (som ges som inparameter)

    //2
    public int getAmountOfQuestionsForACertainCategory(Category category){

        Stream<Question> questionsForCategory = questions.stream().filter(x -> x.category.equals(category));

        long amountOfQuestionsForCategoryLong = questionsForCategory.count();

        return (int) amountOfQuestionsForCategoryLong;
    }

    //Skapa en lista innehållandes samtliga frågesträngar i databasen

    //3
    public List<String> getListOfAllQuestions(){

        Stream<String> streamOfAllQuestions = questions.stream().map(x -> x.question);

        return streamOfAllQuestions.collect(Collectors.toList());
    }

    //Skapa en lista innehållandes samtliga frågesträngar där frågan tillhör en viss kategori
    //Kategorin ges som inparameter

    //4
    public List<String> getAllQuestionStringsBelongingACategory(Category category){

        Stream<Question> categories = questions.stream().filter(x -> x.category.equals(category));

        Stream<String> allQuestions = categories.map(x -> x.question);

        return allQuestions.collect(Collectors.toList());

    }

    //Skapa en lista av alla svarsalternativ, där varje svarsalternativ får förekomma
    // en och endast en gång i den lista som du ska returnera

    //5
    public List<String> getAllAnswerOptionsDistinct(){

        Stream<String> answerStream = questions.stream().flatMap(x -> x.answers.stream());

        Stream<String> distinctAnswers = answerStream.distinct();

        return distinctAnswers.collect(Collectors.toList());
    }

    //Finns en viss sträng, given som inparameter, som svarsalternativ till någon fråga i vår databas?

    //6
    public boolean isThisAnAnswerOption(String answerCandidate){

        Stream<String> streamAnswers = questions.stream().flatMap(x -> x.answers.stream());

        return streamAnswers.anyMatch(x -> x.contains(answerCandidate));

    }

    //Hur ofta förekommer ett visst svarsalternativ, givet som inparameter, i databasen

    //7
    public int getAnswerCandidateFrequncy(String answerCandidate){

        Stream<String> streamAnswers = questions.stream().flatMap(x -> x.answers.stream());

        var answerCandidates =  streamAnswers.filter(x -> x.equals(answerCandidate));

        return (int) answerCandidates.count();

    }

    //Skapa en Map där kategorierna är nycklar och värdena är en lista
    //av de frågesträngar som tillhör varje kategori

    //8
    public Map<Category, List<String>> getQuestionGroupedByCategory(){

//        Map<Integer, List<String>> wordLength = s.stream().collect(groupingBy(n->n.length)

        throw new UnsupportedOperationException("Not supported yet.");

    }

    //Skapa en funktion som hittar det svarsalternativ som har flest bokstäver, i en kategori, given som inparameter
    // OBS: Du måste använda Reduce!

    //9
    public String getLongestLettercountAnwerInAGivenCategory(Category c)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    public static void main(String[] args){
        RewriteMe uppg4 = new RewriteMe();
        
    }


}
