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
  
# 로그인 (일반/페이스북)
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
  * facebook인 경우 email과 token(고유한 정수값)를 이용하여 로그인 판별
 * 반환 값
  * 로그인 성공 시, `{"success": true, "version": "(currently version)"}`
  * 로그인 실패 시, `{"success": false}`
  
  
# 방 만들기
 * 요청
  * POST
  * `/API/Room/create`
 * 인자
  * master_email : String
  * game_mode : String ("Skill" or "Classic")
  * room_title : String
 * 동작
  * 대기방을 생성함 (서버에서는 방 고유 아이디를 생성)
 * 반환 값
  * 방 만들기 성공 시, `{"room": "(Room Number)"}`
  * 방 만들기 실패 시, `{"success": false}`
  
  
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
  
 

#Skill ChessV Server Relay Document

# 방만들기
 * 인자
  * pattern : int //201
  * email : String
  * game_mode : String //"Classic" or "Skill"
  * room_title : String
 * 동작
  * 클라이언트1이 게임 룰과 방제목을 기반으로 방을 생성하고 2분 동안 웹소켓 유지, 
 * 반환 값
  * 방만들기 성공 `{"pattern":201, "success":true}`
  * 방만들기 실패 `{"pattern":201, "success":false, "errorcode":"오류 발생! 다시 입력해주세요."}`

# 방입장
 * 인자
  * pattern : int //202
  * email : String
  * room_id : int
 * 동작
  * 클라이언트2가 room_id와 일치하는 방에 입장
 * 반환 값
  * 방입장 성공 `{"pattern":202, "success":true}`
  * 방입장 실패 `{"pattern":202, "success":false, "errorcode":"방에 입장할 수 없었습니다!"}`

# 게임시작
 * 동작
  * 한 방에 두 명이 모이면 클라1과 클라2에게 게임 시작을 알림
 * 반환 값
  * 게임시작 `{"pattern":203, "start":true}`

# 게임정보 초기화
 * 동작
  * 클라1과 클라2에게 게임 시작정보를 초기화하여 반환함 //203 전송 후 바로
 * 반환 값
  * 게임정보 초기화(Classic) `{"pattern":204, "enemy_nickname":"상대방닉네임", "enemy_score":상대방레이팅}`
  * 게임정보 초기화(Skill) `{"pattern":204}` //추가 필요

# 승리/패배
 * 인자
  * pattern : int //205
  * result : String //"win" or "lose"
 * 동작
  * 클라1과 클라2가 서버에 게임 결과를 전송, 서버는 결과를 바탕으로 레이팅 점수를 반영함, 이후 소켓 종료
 * 반환 값
  * 게임시작 `{"pattern":205, "result":"win or lose"}`

# 항복
 * 인자
  * pattern : int //206
  * result : String //"surrender"
 * 동작
  * 승부를 포기하고 항복을 선언, 서버는 결과를 바탕으로 레이팅 점수를 반영함, 이후 소켓 종료
 * 반환 값
  * 게임시작 `{"pattern":206, "result":"win or lose"}`

# 클라이언트 한정
# Classic
# 무빙
 * 인자
  * pattern : int //1
  * startX : int
  * startY : int
  * endX : int
  * endY : int
  * color : String //"White" or "Black"
  * turnFinish : bool
 * 동작
  * 클라1이 무빙 데이터 전송, 서버는 클라1과 2에게 데이터를 그대로 전송
 * 반환 값
  * 게임시작 `위의 인자값과 동일`

# 프로모션
 * 인자
  * pattern : int //2
  * x : int
  * y : int
  * pieceClass : String //"Queen", "Rook", "Bishop", "Knight"
  * color : String //"White" or "Black"
  * turnFinish : true
 * 동작
  * 클라1이 프로모션 데이터 전송, 서버는 클라1과 2에게 데이터를 그대로 전송
 * 반환 값
  * 게임시작 `위의 인자값과 동일`

# 캐슬링
 * 인자
  * pattern : int //3
  * startX : int
  * startY : int
  * endX : int
  * endY : int
  * color : String //"White" or "Black"
  * turnFinish : true
 * 동작
  * 클라1이 캐슬링 데이터 전송, 서버는 클라1과 2에게 데이터를 그대로 전송
 * 반환 값
  * 게임시작 `위의 인자값과 동일`

# 앙파상
 * 인자
  * pattern : int //4
  * x : int
  * y : int
  * turnFinish : true
 * 동작
  * 클라1이 앙파상 데이터 전송, 서버는 클라1과 2에게 데이터를 그대로 전송
 * 반환 값
  * 게임시작 `위의 인자값과 동일`