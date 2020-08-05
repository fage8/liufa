public class MySigInstance {
    public static volatile MySigInstance instance = null;

    public MySigInstance() {

    }
    public static MySigInstance getInstance(){
      if (instance == null){
          synchronized (MySigInstance.class){
              if (instance == null){
                  instance = new MySigInstance();
              }
          }
      }
      return instance;
    }
}
