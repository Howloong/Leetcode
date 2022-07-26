package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Objects;

/**
 * @ClassName: Animal
 * @Package: leetcode.editor.cn
 * @Description:
 * @Datetime: 2022/7/25   19:03
 * @Author: YuHan.Kang@outlook.com
 */
class Email {
    private String address;
    private String name;

    public Email(String address, String name) {
        this.address = address;
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Email) {
            Email that = (Email) obj;
            return Objects.equals(this.address, that.address) & Objects.equals(this.name, that.name);
        }
        return false;
    }
}
