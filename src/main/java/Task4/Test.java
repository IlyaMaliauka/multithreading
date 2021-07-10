package Task4;

public class Test extends BlockingObjectPool<Entity>{

    public Test(int size) {
        super(size);
    }

    @Override
    protected Entity createObject() {
        return null;
    }
}
