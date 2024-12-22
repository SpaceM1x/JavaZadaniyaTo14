package Vol5Var11;

public class Main {
    public static void main(String[] args) {
        ArtExhibition exhibition = new ArtExhibition();


        exhibition.addExhibit("Звездная ночь", "Винсент Ван Гог", "01.12.2024");
        exhibition.addExhibit("Мона Лиза", "Леонардо да Винчи", "15.01.2025");
        exhibition.addExhibit("Крик", "Эдвард Мунк", "22.02.2025");


        exhibition.showExhibits();
    }
}
