package vaik.study;
/**
 * 此代码演示了2点
 * 1.对象可以在被GC时自我拯救
 * 2.这种自救的机会只有一次，因为对一个对象的finalize()方法最多只会被系统自动调用一次
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVA_HOOK = null;

    public void isAlive(){
        System.out.println("yes, i am still alive;)");
    }

    @Override
    protected void finalize() throws Throwable{
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVA_HOOK = this;
    }

    public static void main(String[] args) throws Throwable{
        SAVA_HOOK = new FinalizeEscapeGC();

        //对象第一次成功拯救自己
        SAVA_HOOK = null;
        System.gc();
        //因为finalize方法优先级很低，所以暂停0.5秒以等待它
        Thread.sleep(500);
        if(SAVA_HOOK !=null){
            SAVA_HOOK.isAlive();
        }else {
            System.out.println("no,i am dead :)");
        }

        //下面这段代码与上面完全相同，但是这次自救失败了
        //对象第一次成功拯救自己
        SAVA_HOOK = null;
        System.gc();
        //因为finalize方法优先级很低，所以暂停0.5秒以等待它
        Thread.sleep(500);
        if(SAVA_HOOK !=null){
            SAVA_HOOK.isAlive();
        }else {
            System.out.println("no,i am dead :)");
        }
    }
}
