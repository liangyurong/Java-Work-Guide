
### 添加页面和更新页面比较类似，更新界面需要赋予初始值

```java
import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.util.Vector;
/**
 * 模块信息：读取之后放进去JTable里面（里面的重写方法是自动调用的，缺一不可）
 */
public class StudentModel extends AbstractTableModel {
    /** 存放行数据 */
    Vector rowDataVector;
    /** 存放列名 */
    Vector columnNameVector;
    /** 查询得到的结果集 */
    static ResultSet rs = null;
    /** select sql*/
    String selectSql="select * from student";
    /**
     * 通过传递的sql语句来获得数据模型
     */
    public StudentModel(String sql) {
        this.init(sql);
    }
    /**
     * 用于初始化数据模型
     */
    public StudentModel() {
        this.init("");
    }
    /**
     * 初始化,登录成功首次进入界面，就会显示全部信息
     * @param sql
     */
    public void init(String sql) {
        if (sql.equals("")) {
            sql = "select * from student";
        }
        getJTableData(sql);
    }
    /**
     * 获取行的数量
     * @return
     */
    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        return rowDataVector.size();
    }
    /**
     * 获取列的数量
     * @return
     */
    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return columnNameVector.size();
    }
    /**
     * 返回某行某列的数据
     * @param rowIndex
     * @param columnIndex
     * @return
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
        return ((Vector) rowDataVector.get(rowIndex)).get(columnIndex);
    }
    /**
     * 设置每个单元格的编辑属性
     * 这个函数AbstractTableModel已经实现，单元格默认是是不允许编辑状态
     * @param rowIndex
     * @param columnIndex
     * @return
     */
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    /**
     * 获取属性名字
     * @param column 没有重写这个方法则默认是ABCDEF...
     * @return
     */
    @Override
    public String getColumnName(int column) {
        // TODO Auto-generated method stub
        return (String) columnNameVector.get(column);
    }
    /**
     * 功能
     *  1.将查询到的信息返回到JTable
     *  2.删除数据之后实时更新JTable
     */
    public void getJTableData(String sql){
        columnNameVector = new Vector();
        columnNameVector.add("id");
        columnNameVector.add("name");
        columnNameVector.add("sex");
        columnNameVector.add("age");
        //rowData存放多行
        rowDataVector = new Vector();
        try {
            DataBase.init();
            rs = DataBase.getResultSet(sql);
            while (rs.next()) {
                Vector row_vector = new Vector();
                row_vector.add(rs.getString(1));
                row_vector.add(rs.getString(2));
                row_vector.add(rs.getString(3));
                row_vector.add(rs.getInt(4));
                rowDataVector.add(row_vector);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBase.close();
        }
        this.fireTableDataChanged();
    }
    /**
     * 实时更新JTable
     */
    public void refreshJTable(){
        getJTableData(selectSql);
    }
}
```

### 主页面

```java
package AA;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
public class RootControlStudentMain extends JFrame implements ActionListener {
    public static void main(String[] args) {
        try {
            new RootControlStudentMain();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    JPanel jp, jp1;
    JButton jb1, jb2, jb3;
    JTable jTable;
    JScrollPane jScrollPane;
    StudentModel studentModel;
    RootControlStudentMain() throws SQLException {
        this.setTitle("student");
        this.setLayout(new BorderLayout());
        this.setBounds(500, 200, 800, 400);
        jp = new JPanel(new FlowLayout());
        jp1 = new JPanel(new BorderLayout());
        jb1 = new JButton("增加");
        jb2 = new JButton("删除");
        jb3 = new JButton("更新");
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jp.add(jb1);
        jp.add(jb2);
        jp.add(jb3);
        //create CollegeModel
        String sql = "select * from student";
        studentModel = new StudentModel(sql);
        jTable = new JTable(studentModel);
        //点击列表头可以进行排序
        TableRowSorter sorter = new TableRowSorter(AccountModel)；
        jTable.setRowSorter(sorter);
        jTable.setAutoCreateColumnsFromModel(true);
        jScrollPane = new JScrollPane(jTable);
        jp1.add(jp, BorderLayout.CENTER);
        jp1.add(jp, BorderLayout.NORTH);
        jp1.add(jScrollPane, BorderLayout.CENTER);
        new Thread().start();
        this.add(jp1);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //add
        if (e.getSource() == jb1) {
            this.dispose();
            new AddStudent();
        }
        //delete
        if (e.getSource() == jb2) {
            //返回给用户点中的行,若该用户一行都没有选，就返回-1
            int rowNum = this.jTable.getSelectedRow();
            if (rowNum == -1) {
                JOptionPane.showMessageDialog(this, "请选中一行");
                return;
            } else {
                String id = (String) studentModel.getValueAt(rowNum, 0);
                DataBase.init();
                String deleteSql = "delete from student where id=" + id + "";
                DataBase.add_update_delete_Method(deleteSql);
                DataBase.close();
                studentModel.refreshJTable();
            }
        }
        //update
        if (e.getSource() == jb3) {
            int rowNum = this.jTable.getSelectedRow();
            if (rowNum == -1) {
                JOptionPane.showMessageDialog(this, "请选中一行");
            } else {
                String id = (String) studentModel.getValueAt(rowNum, 0);
                try {
                    this.dispose();
                    new UpdateStudent(Integer.parseInt(id));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                studentModel.refreshJTable();
            }
        }
    }
}
```

### 增加页面

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
public class AddStudent extends JFrame implements ActionListener {
    JPanel jp, jp1;
    JLabel jl1, jl2, jl3;
    JTextField jt1, jt2, jt3;
    JButton jb1, jb2;
    AddStudent() {
        this.setTitle("add student");
        this.setLayout(new BorderLayout());
        this.setBounds(500, 300, 550, 350);
        /**
         * 初始化组件
         */
        jp = new JPanel();
        GridLayout g = new GridLayout(4, 2);
        g.setVgap(10);
        jp1 = new JPanel(g);
        jl1 = new JLabel("name", JLabel.CENTER);
        jt1 = new JTextField(15);
        jl2 = new JLabel("sex", JLabel.CENTER);
        jt2 = new JTextField(15);
        jl3 = new JLabel("age", JLabel.CENTER);
        jt3 = new JTextField(15);
        jb1 = new JButton("submit");
        jb2 = new JButton("cancel");
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        /**
         * 界面布局
         */
        jp1.add(jl1);
        jp1.add(jt1);
        jp1.add(jl2);
        jp1.add(jt2);
        jp1.add(jl3);
        jp1.add(jt3);
        jp1.add(jb1);
        jp1.add(jb2);
        this.add(jp1);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //添加
        if (e.getSource() == jb1) {
            String name = jt1.getText().trim();
            String sex = jt2.getText().trim();
            int age = Integer.parseInt(jt3.getText().trim());
            //所有信息都不为空，才能添加student
            if ("".equals(name) || "".equals(sex) || "".equals(age)) {
                JOptionPane.showMessageDialog(new JFrame(), "not null", "提示", JOptionPane.WARNING_MESSAGE);
                new AddStudent();
                this.dispose();
                return;
            }
            DataBase.init();
            //sql语句容易写错
            String insertSql = "insert into student(name,sex,age) values ('"
                    + name + "','"
                    + sex + "',"
                    + age + ")";
            if (DataBase.add_update_delete_Method(insertSql) > 0) {
                JOptionPane.showMessageDialog(new JFrame(), "add success", "show", JOptionPane.WARNING_MESSAGE);
                this.dispose();
                try {
                    new RootControlStudentMain();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "add fail", "show", JOptionPane.WARNING_MESSAGE);
            }
            DataBase.close();
        }
        //返回操作页面
        if (e.getSource() == jb2) {
            try {
                new RootControlStudentMain();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            this.dispose();
        }
    }
}
```

### 修改页面

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
public class UpdateStudent extends JFrame implements ActionListener {
    JPanel jp, jp1;
    JLabel jl1, jl2,jl3, jl4;
    JTextField jt1, jt2,jt3, jt4;
    JButton jb1, jb2;
    /** 传入需要更新的student的id */
    int id;
    UpdateStudent(int id) throws SQLException {
        this.id=id;
        this.setTitle("update student");
        this.setLayout(new BorderLayout());
        this.setBounds(500, 300, 550, 480);
        jp = new JPanel();
        GridLayout g=new GridLayout(5,2);
        g.setVgap(10);
        jp1 = new JPanel(g);
        jl1 = new JLabel("id",JLabel.CENTER);
        jt1 = new JTextField(15);
        jt1.setEditable(false);
        jl2 = new JLabel("name",JLabel.CENTER);
        jt2 = new JTextField(15);
        jl3 = new JLabel("sex",JLabel.CENTER);
        jt3 = new JTextField(15);
        jl4 = new JLabel("age",JLabel.CENTER);
        jt4 = new JTextField(15);
        jb1 = new JButton("确认更新");
        jb2 = new JButton("取消更新");
        jb1.addActionListener(this);
        jb2.addActionListener(this);

        DataBase.init();
        String selectSql = "select * from student where id="+id+"";
        ResultSet rs = DataBase.getResultSet(selectSql);
        while (rs.next()) {//获取查询结果的
            jt1.setText(rs.getString(1)==null? null:rs.getString(1).trim());
            jt2.setText(rs.getString(2)==null? null:rs.getString(2).trim());
            jt3.setText(rs.getString(3)==null? null:rs.getString(3).trim());
            jt4.setText(rs.getString(4)==null? null:rs.getString(4).trim());
        }
        DataBase.close();
        jp1.add(jl1);
        jp1.add(jt1);
        jp1.add(jl2);
        jp1.add(jt2);
        jp1.add(jl3);
        jp1.add(jt3);
        jp1.add(jl4);
        jp1.add(jt4);
        jp1.add(jb1);
        jp1.add(jb2);
        this.add(jp1);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //update
        if(e.getSource()==jb1){
            String name = jt2.getText().trim();
            String sex = jt3.getText().trim();
            int age = Integer.parseInt(jt4.getText().trim());
            if("".equals(name)||"".equals(sex)||"".equals(age)){
                JOptionPane.showMessageDialog(new JFrame(), "not null", "提示", JOptionPane.WARNING_MESSAGE);
                try {
                    new RootControlStudentMain();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                this.dispose();
                return;
            }
            DataBase.init();
            String updateSql = "update student set name= '"
                    + name + "',sex='"
                    + sex+"',age="
                    + age+" where id="+id;
            if (DataBase.add_update_delete_Method(updateSql) > 0) {
                JOptionPane.showMessageDialog(new JFrame(), "update success", "show", JOptionPane.WARNING_MESSAGE);
                this.dispose();
                try {
                    new RootControlStudentMain();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "update fail", "show", JOptionPane.WARNING_MESSAGE);
            }
            DataBase.close();
        }
        //cancel update
        if(e.getSource()==jb2){
            this.dispose();
            try {
                new RootControlStudentMain();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
```

### 基于数据库的基本操作

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
* 连接数据，对数据库的增删改查
*  url中的reading是数据库名称，需要对应mysql的文件
*  user和password对应自己的mysql密码
*/
public class DataBase {

    static String url="jdbc:mysql://localhost:3306/school?useSSL=false";
    static String user="root";
    static String password="12345678";
    static Connection conn=null;
    static PreparedStatement ps=null;
    static ResultSet rs=null;
    /**
     * 数据库的初始化连接
     */
    public static void init(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection(url,user,password);
        }catch(Exception e){
            System.out.println("连接数据库失败！！！");
            e.printStackTrace();
        }
    }
    /**
     * 数据库的增加，更新，删除. 参数：sql语句
     * @param sql
     * @return
     */
    public static int add_update_delete_Method(String sql){
        int i=0;
        try{
            ps=conn.prepareStatement(sql);
            boolean flag=ps.execute();
            //如果第一个结果是结果集对象，返回true。如果第一个结果是更新计数或是没有结果，返回false
            if(!flag){
                i++;
            }
        }catch (Exception e){
            System.out.println("数据库增删改异常");
            e.printStackTrace();
        }finally {
            return i;
        }
    }
    /**
     * 数据库的查询的结果
     * @param sql
     * @return
     */
    public static  ResultSet getResultSet(String sql){
        try{
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
        }catch (Exception e){
            System.out.println("数据库查询异常！！！");
            e.printStackTrace();
        }finally {
            return rs;
        }
    }
    /**
     * 关闭数据库资源
     */
    public static void close(){
        try{
            if(rs!=null){
                rs.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            if(ps!=null){
                ps.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            if(conn!=null){
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
```





