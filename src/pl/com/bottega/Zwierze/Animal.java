package pl.com.bottega.Zwierze;


public class Animal {

    private String name;
    private MoveStrategy moveStrategy;
    private EatStrategy eatStrategy;

    public Animal(String name, MoveStrategy moveStrategy, EatStrategy eatStrategy){
        this.name= name;
        this.moveStrategy = moveStrategy;
        this.eatStrategy = eatStrategy;
    }

    public void presentYourSelf() {
        System.out.println(name);
        moveStrategy.move();
        eatStrategy.eat();
    }
}
