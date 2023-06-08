import java.util.ArrayList;
import java.util.Scanner;

class Student {
    public static Scanner scanner = new Scanner(System.in);
    private long id;
    private String name;
    private char sex;
    private float chinese;
    private float math;
    private float english;

    public Student() {
    }

    public Student(long id, String name, char sex, float chinese, float math, float english) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.math = math;
        this.english = english;
        this.chinese = chinese;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public float getChinese() {
        return chinese;
    }

    public void setChinese(float chinese) {
        this.chinese = chinese;
    }

    public float getMath() {
        return math;
    }

    public void setMath(float math) {
        this.math = math;
    }

    public float getEnglish() {
        return english;
    }

    public void setEnglish(float english) {
        this.english = english;
    }

    public void addStudent(ArrayList<Student> students) {
        System.out.println("录入学生数据");
        System.out.println("请依次输入如下数据：");
        long id;
        while (true) {
            System.out.println("学号");
            id = scanner.nextInt();
            if (isValid(students, id)) {
                System.out.println("学号重复，请重新输入");
            } else {
                break;
            }
        }

        System.out.println("姓名");
        String name = scanner.next();
        System.out.println("性别");
        char sex = scanner.next().charAt(0);
        System.out.println("语文");
        float chinese = scanner.nextFloat();
        System.out.println("数学");
        float math = scanner.nextFloat();
        System.out.println("英语");
        float english = scanner.nextFloat();
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setSex(sex);
        student.setChinese(chinese);
        student.setMath(math);
        student.setEnglish(english);
        students.add(student);
        System.out.println("添加成功");
    }

    public boolean isValid(ArrayList<Student> students, long id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void showAvg(ArrayList<Student> students) {
        System.out.println("输出学生统计数据");
        if (students.size() == 0) {
            System.out.println("当前无数据，请先添加数据！");
        } else {
            System.out.println("学号\t\t姓名\t\t性别\t\t");
            System.out.println("---------------------------------");
            for (Student student : students) {
                System.out.format("%d\t\t%s\t\t%c\n", student.getId(), student.getName(), student.getSex());
            }
        }
    }

    public void lookupStudent(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("不好意思，目前还没有学生信息，请先添加学生信息！");
        } else {
            System.out.println("所有学生成绩如下");
            System.out.println("学号\t\t姓名\t\t性别\t\t语文\t\t数学\t\t英语");
            for (Student student : students) {
                System.out.format("%d\t%s\t%c\t%.2f\t%.2f\t%.2f\n", student.getId(), student.getName(), student.getSex(), student.getChinese(), student.getMath(), student.getEnglish());
            }
        }
        System.out.println("查找学生成绩");
        if (students.size() == 0) {
            System.out.println("当前无数据，请添加后重试");
        } else {
            System.out.println("请输入要查找学生的学号：");
            long id = scanner.nextLong();
            int flag = -1;
            Student student = new Student();
            for (int i = 0; i < students.size(); i++) {
                student = students.get(i);
                if (student.getId() == id) {
                    flag = i;
                    break;
                }
            }

            if (flag == -1) {
                System.out.println("未找到对应学号的学生，请确认后重新输入！");
            } else {
                System.out.println("对应学号的学生成绩如下：");
                System.out.println("学号\t\t姓名\t\t性别\t\t语文\t\t数学\t\t英语");
                System.out.format("%d\t%s\t\t%c\t\t%.2f\t%.2f\t%.2f\n", student.getId(), student.getName(), student.getSex(), student.getChinese(), student.getMath(), student.getEnglish());
            }
        }

    }

    public void modifyStudent(ArrayList<Student> students) {
        System.out.println("修改学生成绩");
        if (students.isEmpty()) {
            System.out.println("当前无数据，请添加后重试");
        } else {
            System.out.println("请输入要修改学生的学号：");
            long id = scanner.nextLong();

            for (Student student : students) {
                if (id == student.getId()) {
                    System.out.println("请重新输入该学生的信息");
                    System.out.println("姓名");
                    String name = scanner.next();
                    System.out.println("性别");
                    char sex = scanner.next().charAt(0);
                    System.out.println("语文");
                    float chinese = scanner.nextFloat();
                    System.out.println("数学");
                    float math = scanner.nextFloat();
                    System.out.println("英语");
                    float english = scanner.nextFloat();

                    student.setName(name);
                    student.setSex(sex);
                    student.setChinese(chinese);
                    student.setMath(math);
                    student.setEnglish(english);
                    System.out.println("修改学生成功！");
                    System.out.println("学号  姓名  性别 语文 数学 英语");
                    System.out.format("%d\t%s\t\t%c\t\t%.2f\t%.2f\t%.2f\n", student.getId(), student.getName(), student.getSex(), student.getChinese(), student.getMath(), student.getEnglish());
                } else {
                    System.out.println("未找到对应学号的学生，请确认后重新输入！");
                }
                break;
            }
        }
    }

    public void deleteStudent(ArrayList<Student> students) {
        System.out.println("删除学生成绩");
        if (students.isEmpty()) {
            System.out.println("当前无数据，请添加后重试");
        } else {
            System.out.println("输入要删除学生成绩的学号");
            long id = scanner.nextLong();

            int index = -1;
            for (int i = 0; i < students.size(); i++) {
                Student student = students.get(i);
                if (student.getId() == id) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                System.out.println("未找到对应学号学生信息，请确认后再删除！");
            } else {
                students.remove(index);
                System.out.println("删除学生成功");
            }
        }
    }

    public void sortStudent(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("当前无数据，请添加后重试");
        } else {
            System.out.println("排序后的学生成绩");
            System.out.println("学号  姓名  性别 语文 数学 英语");
            for (Student student : students) {
                System.out.format("%d\t%s\t%c\t%.2f\t%.2f\t%.2f\n", student.getId(), student.getName(), student.getSex(), student.getChinese(), student.getMath(), student.getEnglish());
            }
        }
    }
}

public class work {
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        do {
            System.out.println("----------欢迎使用学生成绩管理系统-----------");
            System.out.println("1.添加学生信息");
            System.out.println("2.查看学生信息");
            System.out.println("3.修改学生信息");
            System.out.println("4.删除学生信息");
            System.out.println("5.排序");
            System.out.println("6.退出");

            Student student = new Student();

            System.out.println("输入你的选择");
            String choice = scanner.next();
            switch (choice) {
                case "1":
                    student.addStudent(students);
                    break;
                case "2":
                    student.lookupStudent(students);
                    break;
                case "3":
                    student.modifyStudent(students);
                    break;
                case "4":
                    student.deleteStudent(students);
                    break;
                case "5":
                    student.sortStudent(students);
                    break;
                case "6":
                    System.exit(0);
                default:
                    break;
            }
        } while (true);
    }
}
