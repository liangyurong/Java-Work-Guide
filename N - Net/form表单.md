1. form 的提交行为需要通过type=submit实现
2. form 中的method 属性不指定时， form 默认的提交方式为 get请求。
3. form 表单的提交后会有默认行为，会跳转刷新到action 的页面
4. form 表单的提交方式，==请求头默认的content-type 为 x-www-form-urlencoded==
5. 当一个form 表单内部，所有的input 中只有一个 type='text' 的时候，enter 键会有默认的提交行为（注意前提条件）。
6. 、