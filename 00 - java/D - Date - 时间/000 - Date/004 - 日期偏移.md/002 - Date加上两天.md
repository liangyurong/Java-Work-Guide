


```jshelllanguage
  public static void main(String[] args) {
    Date now = new Date();
    Calendar c = Calendar.getInstance();
    c.setTime(now);
    c.add(Calendar.DAY_OF_MONTH, 2);
    Date newDate = c.getTime();
    System.out.println(newDate);
  }
```
