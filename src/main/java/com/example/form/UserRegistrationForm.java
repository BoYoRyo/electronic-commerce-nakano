package com.example.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

/**
 * ユーザー登録のフォームクラス.
 * 
 * @author nakanoryo
 *
 */
@Validated
public class UserRegistrationForm {
	/** 姓 */
	@NotBlank(message = "苗字を入力してください")
	private String familyName;

	/** 名 */
	@NotBlank(message = "名前を入力してください")
	private String firstName;

	/** メールアドレス */
	@NotBlank(message = "メールアドレスを入力してください")
	@Email(message = "メールアドレスの形式が不正です")
	private String email;

	/** パスワード */
	@NotBlank(message = "パスワードを入力してください")
	@Size(min = 8, max = 12, message = "8～12字で入力してください")
	private String password;

	/** 郵便番号 */
	@NotBlank(message = "郵便番号を入力してください")
	@Pattern(regexp = "^[0-9]{3}-[0-9]{4}$", message = "郵便番号はXXX-XXXXの形式で入力してください")
	private String zipcode;

	/** 住所 */
	@NotBlank(message = "住所を入力してください")
	private String address;

	/** 電話番号 */
	@NotBlank(message = "電話番号を入力してください")
	@Pattern(regexp = "^\\d{2,4}-\\d{2,4}-\\d{4}$", message = "電話番号はXXXX-XXXX-XXXXの形式で入力してください")
	private String telephone;

	@Override
	public String toString() {
		return "UserRegistrationForm [familyName=" + familyName + ", firstName=" + firstName + ", email=" + email
				+ ", password=" + password + ", zipcode=" + zipcode + ", address=" + address + ", telephone="
				+ telephone + "]";
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
