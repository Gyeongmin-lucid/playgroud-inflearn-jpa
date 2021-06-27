package inflearn.jpa.gwin;

import javax.persistence.Embeddable;
import sun.applet.AppletViewer;

//Entity를 primitive한 객체 외에 내가 만든 클래스는 사용할수 없나?
// -> Embeddable! (생성) / Embedded (사용)
//같은 Embeddable을 하나의 Entity에서 두번 사용하고 싶다?
// -> AttributeOverride
// ex. @AttributeOverride(name = "column 이름", column = @Column(name = "새로운 이름"))
@Embeddable
public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;
}
