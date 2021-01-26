package io.terminus.trantor.demo.model;

import io.terminus.trantor.api.annotation.*;
import io.terminus.trantor.api.annotation.typemeta.*;
import io.terminus.trantor.module.base.dictionary.Country;

import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * @author ymf
 * @date 2021/1/19 10:31 上午
 */
@TModel(
        name = "学生模型",
        mainField = Student.name_field,
        indexes = {
                @Index(columns = Student.country_field)
        },
        fieldGroups = {
                @FieldGroup(fieldName = {Teacher.id_field, Teacher.name_field}),
                @FieldGroup(fieldName = {Teacher.name_field}, type = FieldGroupType.SEARCHABLE),
                @FieldGroup(fieldName = {Teacher.name_field}, type = FieldGroupType.SEARCH_SHOW),
        },
        enableSearch = true,
        enableImport = true,
        enableExport = true
)
public class Student extends BaseModel<Long> {

    private static final long serialVersionUID = -4434701696846600802L;


    @TModelField(name = "姓名", nullable = false)
    @NotNull(message = "姓名不可为空")
    private String name;

    @TModelField(name = "手机号", type = TModelFieldType.Phone)
    private String mobile;

    @TModelField(name = "邮箱", type = TModelFieldType.Email)
    private String email;

    @TModelField(name = "国家")
    @DictionaryMeta(clazz = Country.class)
    private String country;

    @TModelField(name = "图片")
    @ImageMeta(maxSize = 3 * 1024)
    private String image;

    @TModelField(name = "简述", type = TModelFieldType.MultiText)
    @TextMeta(length = 512)
    private String desc;

    @TModelField(name = "个人履历", type = TModelFieldType.RichText)
    private String resume;

    @TModelField(name = "薪水")
    @NumberMeta(unit = "元")
    private Double salary;

    /**
     * 定义OneToOne：一个学生只能含有一张校园卡,一张校园卡同时只能对应一个学生
     */
    @TModelField(name = "学生卡")
    @RelationMeta(name = "StudentAndStudentCard")
    private StudentCard studentCard;

    @TModelField(name = "所属班级")
    @RelationMeta(name = "Classes")
    private Classes classes;

    /**
     * 定义OneToMany，由于类型擦除，需要modelClass定义对端模型
     * name:关系名称，正则匹配：[A-Z][A-zA-Z0-9]*。
     */
    @TModelField(name = "课程")
    @RelationMeta(name = "StudentAndSubject", modelClass = Subject.class)
    private List<Subject> subjects;

    /**
     * 定义ManyToMany，由于类型擦除，需要modelClass定义对端模型
     */
    @TModelField(name = "教师")
    @RelationMeta(name = "StudentAndTeacher", modelClass = Teacher.class, opposite = RelationType.ToMany)
    private List<Teacher> teachers;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public StudentCard getStudentCard() {
        return studentCard;
    }

    public void setStudentCard(StudentCard studentCard) {
        this.studentCard = studentCard;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
}
