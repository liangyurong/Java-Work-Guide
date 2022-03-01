

### 1、前端传递json数据，需要定义

不需要使用var jsonData = JSON.stringify(this.survey);

```text
      generateSurvey: function () { //生成问卷

        let config = {
          headers: {
            'Content-Type': 'application/json'
          }
        }

        this.$axios({
          method: 'post',
          url: '/createQuestionnaire',
          data: this.survey   // 不需要使用var jsonData = JSON.stringify(this.survey);，
        }).then(response => { // 后端响应回来的结果
          // eslint-disable-next-line no-labels,no-unused-expressions
          data:[{ // 真正响应的数据
          }]
          if (response.data.code === 0) {
            this.$router.push({path: 'success'}).catch(err => {
              window.alert('跳转失败')
            })
          } else {
            window.alert('失败')
          }
        }).catch(error => console.log(error, 'error'))
      }
    },
```

