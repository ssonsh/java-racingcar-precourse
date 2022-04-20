# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

---
# 기능목록 도출

### 1. 자동차 도메인을 생성한다.

- 이름을 가지는 자동차 도메인을 생성한다.
    - 실제 이름은 사용자 입력으로 전달받게 될 예정이다.
- 재약조건
    - 이름은 5자를 넘을 수 없다.
        - 넘어가게 되는경우 IllegalArgumentException 을 발생시킨다.
        - Exception Message에는 "[ERROR]" 라는 메세지가 포함된다.
    - 이름이 공란일 수 없다.
        - 공란인 경우 IllegalArgumentException 을 발생시킨다.
        - Exception Message에는 "[ERROR]" 라는 메세지가 포함된다.

### 2. 여러대의 자동차를 관리하는 1급 콜랙션 도메인을 생성한다.

- 여러대의 자동차를 관리하는 1급 콜랙션 도메인인 Cars 를 생성한다.
- Cars 도메인안에는 Car를 List Collection으로 관리할 수 있다.
- 기능
  - size() 메소드를 이용해 생성된 Car 객체의 갯수를 조회할 수 있다. 
  - add(Car car) 메소드를 이용해 동적으로 Car 객체를 추가할 수 있다.

### 3. 자동차 도메인을 수정한다. : 전진 상태 추가

- 자동차 도메인은 이름을 가지고 있다.
- 추가로 전진 상태를 가질 수 있는 자동차 도메인으로 수정한다.
- 전진 상태를 거리라는 Distance 값 객체를 이용한다.
  - 생성 시 초기 거리 값은 0이다. 

### 4. 자동차 전진을 위한 Random 값을 생성할 수 있는 생성기 개발
- Random 값은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange() 메서드를 이용한다. 
- 생성되는 Random 값의 범위는 0에서 9사이의 값이다.

### 5. 자동차의 전진/멈춤을 판단하는 판단처리기 개발
- Engine 도메인을 이용해 자동차의 전진/멈춤 처리 판단을 수행한다.
- 기준
  - 생성된 Random 값이 4 이상인 경우 “전진”
  - 생성된 Random 값이 3 이하이면 “멈춤”

### 6. 자동차 도메인에 전진을 위한 Engine 도메인을 상태로 가지도록 기능을 추가한다.
- 자동차는 “전진”에 대한 상태를 가지고 있으며
- 이 상태를 처리할 수 있는 Engine 도메인을 자동차 도메인에 추가한다.
- 자동차 도메인은 run() 메소드를 제공하며 호출 시 Enigne 도메인의 run() 을 호출한다.
- Eninge 도메인의 run() 메소드 호출 결과에 따라 전진인 경우 Distance 거리 값을 +1 한다.

### 7. 1급 콜랙션 도메인 Cars 을 이용하여 자동차의 전진/멈춤 처리를 일괄로 할 수 있다.
- Cars 1급 콜랙션에서 전진하는 메소드를 일괄로 호출 할 수 있다.
- 전진하는 메소드를 호출한 결과로 각 Car 자동차 도메인은 전진을 하거나 멈추게 된다.
- 기능
  - Cars 1급 콜랙션에 run() 메소드가 제공된다.
  - run() 메소드는 1급 콜랙션에서 관리하고 있는 여러 Car 객체의 run()을 호출한다.

### 8. 사용자 입력값 처리 : 자동차 등록
- 자동차를 등록하는 입력값 처리
    - ex. “pobi,woni,jun”
- 입력된 값이 없는 경우 잘못된 값을 입력하면 IllegalArgumentException이 발생된다.
    - Exception 메세지에는 [ERROR] 가 포함된다.
- 입력된 값을 자동차 이름 값 객체인 Name 으로 변환하는 과정에서 이름의 제약조건을 위배하면 IllegalArgumentException이 발생된다.
    - 이름의 제약조건은 5자를 넘을 수 없다.
- 입력이 잘못된 경우 Exception 발생 처리 이후 그 부분부터 다시 입력을 받는다.

### 9. 사용자 입력값 처리 : 시도횟수 등록
- 전진처리를 수행할 시도 횟수를 입력한다.
    - ex. 5
- 잘못된 값을 입력하면 IllegalArgumentException이 발생된다.
    - Exception 메세지에는 [ERROR] 가 포함된다.
    - 입력 값은 빈값일 수 없다.
    - 입력 값은 숫자만 허용한다.
- 입력이 잘못된 경우 Exception 발생 처리 이후 그 부분부터 다시 입력을 받는다.


### 10. 게임 실행을 위한 RacingGame 컨트롤러를 생성한다.

- 사용자로부터 자동차 이름을 입력받고
    - 입력받은 자동차 이름을 바탕으로 자동차 도메인을 생성해낸다.
- 수행횟수를 입력받는다.
- 입력된 정보를 바탕으로 RacingGame을 실행하는 역할을 수행한다.
- 실행을 위한 게임 도메인인 RacingGame 을 생성하고 입력된 자동차들과, 시도횟수를 가지도록 한다.
  - 수행횟수만큼 각 자동차들이 전진/멈춤이 실행된다.
  - 실행횟수가 모두 수행되면 게임은 종료된다.


### 11. 자동차가 전진/멈춤이 실행되면 각 자동차들의 차수별 실행결과를 출력할 수 있다.

- 전진인 경우 “-” 가 추가된다.
- 멈춤인 경우 아무런 텍스트가 표현되지 않는다.
- 출력 시 포맷은 아래와 같다.
    - pobi : ——
    - woni : —-
    - jun : -

### 12. 우승자 선정 / 출력하기

- 가장 먼 거리를 이동한 자동차를 우승자로 선정한다.
- 우승자는 1명 이상이다.