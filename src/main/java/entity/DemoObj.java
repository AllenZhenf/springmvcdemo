package entity;

/**
 * @author Allen
 * @create 2018-09-14 下午 3:08
 * @desc
 **/
public class DemoObj {
    private Long id;
    private String name;

    public DemoObj(){
        super();
    }

    public DemoObj(Long id,String name){
        this.id=id;
        this.name=name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
