
### 将符合条件的都删除，不是只删除一个

```jshelllanguage
    @ApiOperation("根据问题id删除选项")
    @GetMapping("deleteOption")
    public void deleteOption(@RequestParam("questionId") String questionId){
        // 根据问题id删除问题的所有选项
        QueryWrapper<Option> wrapper = new QueryWrapper<>();
        // DELETE FROM t_option WHERE belong_question_id = ?
        wrapper.eq("belong_question_id",questionId);
        optionService.remove(wrapper);
    }
```
