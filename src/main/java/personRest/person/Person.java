package personRest.person;

import org.apache.commons.codec.binary.Hex;
import personRest.uuid.uuid;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Person {


    private long id;
    private String firstName, lastName;
    private String username, passwordMD5;
    private uuid UUID;

    public boolean checkPassword(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update((password).getBytes(Charset.forName("UTF8")));
            byte[] resultByte = messageDigest.digest();
            String result = new String(Hex.encodeHex(resultByte));
            if (result.equals(this.passwordMD5))
                return true;
            else
                return false;
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Invalid");
        }
        return false;
    }


    public Person()
    {

    }

    public Person(long id, String name, String surname, String username, String password) {
        this.id = id;
        this.firstName = name;
        this.lastName = surname;
        this.username = username;
        setPasswordMD5(password);
        this.UUID = new uuid();
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public uuid getUUID() {
        return UUID;
    }

    public void setUUID(uuid UUID) {
        this.UUID = UUID;
    }

    public String getPasswordMD5() {
        return passwordMD5;
    }


    public void setPasswordMD5(String passwordMD5) {
        try {

            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update((passwordMD5).getBytes(Charset.forName("UTF8")));
            byte[] resultByte = messageDigest.digest();
            String result = new String(Hex.encodeHex(resultByte));
            this.passwordMD5 = result;
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Invalid");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void updateUUID() {
        this.UUID = new uuid();
    }
}
