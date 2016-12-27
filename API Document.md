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
  
# 로그인(일반/페이스북)
 * 요청
  * POST
  * `/API/login`
 * 인자 
  * 일반 로그인
  * mode : "normal", String
  * email : String
  * password : String
  * 페이스북 로그인
  * mode : "facebook", String
  * email : String
  * token : String
 * 동작
  * mode를 분류하여 normal인 경우 email과 password를 이용하여 로그인 판별 
  * facebook인 경우 email과 id(고유한 정수값)를 이용하여 로그인 판별
 * 반환 값
  * 로그인 성공 시, `{"success": true, "version": "(currently version)"}`
  * 로그인 실패 시, `{"success": false}`
  
  
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
  
 
