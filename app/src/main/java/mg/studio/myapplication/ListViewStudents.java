package mg.studio.myapplication;


class ListViewStudents {
    private String name;
    private int studentId;

    //Setters
    public ListViewStudents(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    //Getters
    public String getName() {
        return name;
    }

    public int getStudentId() {
        return studentId;
    }


}
