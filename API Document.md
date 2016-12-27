#Skill ChessV Server API Document
# 일반 회원가입
 * 요청
  * POST
  * `/API/normal_register`
 * 인자 
  * email : String
  * password : String
  * nickname : String
 * 동작
  * 일반 회원으로 가입한다.
 * 반환 값
  * 회원가입 성공 `{"success":true}`
  * 회원가입 실패(입력한 값이 하나라도 없을 경우) `{"success":false, "errorcode":"오류 발생! 다시 입력해주세요."}`
  
# 페이스북 회원가입
 * 요청
  * POST
  * `/API/fb_register`
 * 인자 
  * email : String
  * token : String
  * nickname : String
 * 동작
  * 페이스북 회원으로 가입한다.
 * 반환 값
  * 회원가입 성공 `{"success":true}`
  * 회원가입 실패(입력한 값이 하나라도 없을 경우) `{"success":false, "errorcode":"오류 발생! 다시 입력해주세요."}`
  
# 버전
 * 요청
  * GET
  * `/version`
 * 인자 
  * (없음)
 * 동작
  * 버전을 JSON 형태로 반환한다.
 * 반환 값
  * `{"version":"(currently version)"}`
  
 
