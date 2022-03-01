
连接 https://www.youranshare.com/blog/sid/67.html

### Jtable的使用，封装一个类，将这个类的数据读取放进JTable中

```java
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class ZZ {
    public static void main(String[] args) {
        new ZZ();
    }
    public ZZ(){
        Demo d=new Demo();
        JTable jTable=new JTable(d);
        JFrame j=new JFrame();
        j.setTitle("Jtable");
        j.setBounds(0, 0, 500, 500);
        JScrollPane js=new JScrollPane(jTable);
        /**
         * 绝对不可以用JScrollPane js=new JScrollPane(); js.add(Jtable),这样子显示不出数据
         */
        j.add(js);
        j.setVisible(true);
        j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
class Demo extends AbstractTableModel{
    /**
     * 对于新构建的一个Tablemodel，必须有一个有两个vector，一个是作为列表的标题，一个是作为二维数组存储数据
     *
     * 进行JTable jTable=new JTable(new Demo);的时候，会自动调用这个Demo的方法来读取数据
     *
     * Jtable一般需要放进JScrollPane中
     *
     * 一定要做的事情是：重写三个方法
     *  public int getRowCount()    返回行的大小
     *  public int getColumnCount() 返回列的大小
     *  public Object getValueAt(int rowIndex, int columnIndex) 返回某行某列的数据
     */
    private Vector tableData_vector;
    private Vector tableTitle_vector;
    public Demo(){
        tableData_vector =new Vector();
        tableTitle_vector =new Vector();
        tableTitle_vector.add("name");
        tableTitle_vector.add("age");
        tableTitle_vector.add("sex");
        String[] line1={"001","11","man"};
        String[] line2={"002","22","man"};
        String[] line3={"003","33","woman"};
        tableData_vector.add(line1);
        tableData_vector.add(line2);
        tableData_vector.add(line3);
    }
    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        return tableData_vector.size();
    }
    @Override
    public int getColumnCount() {
        return tableTitle_vector.size();
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] line=(String[]) tableData_vector.get(rowIndex);
        return line[columnIndex];
        //如果我们是将 线性表Vector挂到了Vector上要注意每次我们获取的是 一行线性表
        //return ((Vector)TableData.get(rowIndex)).get(columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        //这个函数式设置每个单元格的编辑属性的
        //这个函数AbstractTableModel已经实现，默认的是 不允许编辑状态
        //这里我们设置为不允许编辑状态
        return false;//super.isCellEditable(rowIndex, columnIndex);
    }
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        //当单元格的数据发生改变的时候调用用该函数重设单元格的数据
        //我们想一下，数据是放在TableData 中的，说白了修改数据就是修改TableData中的数据，所以我们仅仅在此处将TableData的对应数据修改即可
        ((String[])tableData_vector.get(rowIndex))[columnIndex]=(String)aValue;
        super.setValueAt(aValue, rowIndex, columnIndex);
        //其实这里super的方法是调用了fireTableCellUpdated()方法，只对应更新了对应单元格的数据
        //fireTableCellUpdated(rowIndex, columnIndex);
    }
    //得到属性名字
    public String getColumnName(int column) {
        // TODO Auto-generated method stub
        return (String) tableTitle_vector.get(column);
    }
}
```
