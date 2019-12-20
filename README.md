# Precourse Week 1 - 숫자 야구 게임

## 미션 요구사항

<details>
<summary>자세히</summary>

<br>

> ### 기능 요구사항
>
> 1. 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
>
> 2. 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고, 그 힌드를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
>
>    - [예시] 상대방(컴퓨터)의 수가 425일 때, 123을 제시한 경우 : 1 스트라이크, 456을 제시한 경우 : 1 스트라이크 1볼, 789를 제시한 경우 : 낫싱
>
> 3. 위 숫자 야구게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 3개 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
>
> 4. 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
>
> 5. 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.

> ### 프로그래밍 요구사항
>
> 1. 자바 코드 컨벤션을 지키면서 프로그래밍한다.
>
>    - [Google Java Style Guide 참고](https://google.github.io/styleguide/javaguide.html)
>
>    - [자바 코딩 규칙(Java Code Conventions) 참고](https://myeonguni.tistory.com/1596)
>
> 2. indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
>
> 3. 3항 연산자를 쓰지 않는다.
>
> 4. 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.

</details>

<br>

## 구현해야 할 기능 목록

1. (기능 3) **1부터 9까지 서로 다른 수**로 이루어진 **3자리의 수**를 생성하는 기능.

   - (구현) 숫자 생성시 **0**이 포함되지 않도록 생성.

   - (구현) 각 자리의 수가 **서로 다른 3자리의 수** 생성 (이전 자리의 수와 비교 필요).

2. (기능 3) 사용자로부터 **3자리 수를 입력**받는 기능.

   - (예외) **1부터 9까지의** 3자리 수가 입력되지 **않은** 경우 (문자 또는 3자리 미만, 초과의 경우, **0이 들어올 경우**).

   - (예외) 3자리 수 중에서 **같은 수가 입력**된 경우.

   - ~~(예외) **0**이 입력된 경우~~ - 첫번째 예외와 병합.

3. (기능 2) **스트라이크**의 개수를 구하는 기능.

   - (구현) 생성된 수와 입력된 수 비교 후 **동일한 자리 - 동일한 수** 의 개수 측정.

4. (기능 2) **볼**의 개수를 구하는 기능.

   - (구현) 생성된 수와 입력된 수 비교 후 **서로 다른 자리 - 동일한 수** 의 개수 측정.

5. (기능 2) **포볼**(낫싱)인지 여부를 판단하는 기능.

   - (구현) 스트라이크의 개수와 볼의 **개수가 0**일 경우로 판단.

6. (기능 3) 스트라이크, 볼, 또는 포볼(낫싱)에 대한 결과를 **출력**.

   - (구현) 포볼(낫싱)일 경우를 출력.

   - (구현) 위 경우가 아닐 시 스트라이크와 볼의 개수를 출력.

7. (기능 4) 답과 일치하면 게임을 **종료**하는 기능.

   - (구현) **스트라이크의 개수가 3개**이면 답과 일치하므로 게임 종료 ("게임 종료" 출력문도 함께 출력).

8. (기능 5) 게임을 종료한 후 **다시 시작**하거나 완전히 **종료**하는 기능.

   - (구현) **1번**을 입력 받으면 게임을 **다시 시작** ([구현해야 할 기능](#구현해야-할-기능-목록)을 처음부터 다시 진행).

   - (구현) **2번**을 입력 받으면 게임(프로그램) **종료**.

   - (예외) **1또는 2가 아닌 입력**이 들어올 경우.

<br>

## 개발 진행 계획

<details>
<summary>자세히</summary>

<br>

1. 어떤 프로젝트인지와 구현해야 할 기능을 대략적으로 작성.

   - 과제에 진행에 필요한 내용들을 [README.md](./README.md)에서 모두 볼 수 있도록 작성.

2. [구현해야 할 기능 목록](#구현해야-할-기능-목록)에 대한 세부적인 추가 기능 및 예외 처리 목록 작성.

   - 구현 방법과 예외 처리에 대한 간략한 설명 및 계획 추가.

3. [구현해야 할 기능 목록](#구현해야-할-기능-목록) 순서대로 Class 생성 및 코드 작성 ([기능의 함수화](#프로그래밍-요구사항)).

   - 구현해야 할 기능에 따른 Class 설정.

   - 최대한 Code Conventions를 지키면서 작성 (Naming에도 신경쓰기).

4. 전체적인 리펙토링 ([기능의 함수화](#프로그래밍-요구사항) 확인, 상수 사용 확인, 코드의 중복 여부 확인).

   - 전체 코드를 재확인하면서 기능을 좀 더 세분화시켜 함수화하는 리펙토링 진행 (1차 리펙토링).

   - 상수 사용되지 않은 부분을 수정하고 코드의 중복 사용 부분 수정.

   - 불필요하게 존재하는 if-else문을 if문으로 수정하여 코드의 간결화.

   - 클래스의 객체 지향 판단 후 static 함수 수정, 형식에 어긋나는 명명 일부 수정 및 일부 주석 수정.

5. ~~[프로그래밍 요구사항](#프로그래밍-요구사항) 중 코드 부분을 중점적으로 확인 (indent depth와 3항 연산자).~~

   - [개발 진행 계획 4 (1차 리펙토링)](##-개발-진행-계획)를 진행하면서 함께 수정 (indent가 3인 부분들을 2로 수정).

6. [프로그래밍 요구사항](#프로그래밍-요구사항) 중 Convention을 중점적으로 확인.

   - code fommat을 통한 1차 code convention 체크.

   - code convention 2차 체크 (파일 구조, 들여쓰기, 주석, 선언, 복합문, 빈 공간에 대하여 수정).

   - code convention 3차 체크 (명명 규칙, 좋은 프로그래밍 습관), 클래스, 메서드, 변수의 이름에서 최대한 역할이 드러나도록 명명 수정.

   - code convention 4차 체크 (oracle의 java code convention example code 참고).

7. 추가적인 리펙토링 계속 진행.

   - 가독성을 위해 유효성 검사 부분 전체 수정 (계속 stack을 쌓으면서 안으로 들어가는 형식을 수정).

   - 변수의 추가 또는 불필요한 변수 삭제, 반환문 수정을 통한 조건문 축소, 일부 주석과 메서드 수정.

   - Scanner.next() 함수에서 버퍼에 쌓이는 문제를 nextLine() 함수로 교체하여 해결.

</details>

<br>

## 추가 리펙토링 진행 - 클래스 분리 연습

<details>
<summary>자세히</summary>

<br>

> 우아한 형제들 기술 블로그의 [생각하라, 객체지향처럼](http://woowabros.github.io/study/2016/07/07/think_object_oriented.html) 참고
>
> [객체 지향 설계 원칙](https://gmlwjd9405.github.io/2018/07/05/oop-solid.html) 참고

<br>

- 클래스를 새로 분류 진행.

  1. 입력 타입

  2. 출력 타입

  3. 게임 관리자 타입

  4. 게임 타입

  5. 컴퓨터 타입

  6. ~~유저 타입~~

     - '세자리 수를 입력해라'라는 메시지를 유저에게 보는 것보다 '세자리 수를 유저로부터 입력 받아와라'라는 메시지를 Input UI에게 보내는 것이 더 적절하다고 생각이 들어 해당 클래스 삭제.

     - 입력의 유효성은 게임 타입에서 판단하는 것이 더 적절하다고 생각.

  7. 심판 타입

  8. 유효성 검증 타입

- 전체적인 리펙토링 완료

  - 최대한 각각의 역할을 생각하고 객체지향적으로 클래스 분류 작업 진행.

  - UI 로직과 비즈니스 로직을 한 클래스에 담지 않고 분리 진행.

  - 추후에, Exception 오버라이딩을 통한 예외 처리 진행.

</details>

<br>

## 오프라인 테스트 준비 - 최종 리팩토링 연습

### 중점적인 연습 진행 부분

1. 원시타입과 문자열 포장 연습

   - Enum 또는 클래스로 포장.

2. 일급 컬렉션 사용

   - 컬렉션 단 하나만 인스턴스 변수로 가지는 클래스.

### 클래스 분리 계획

1. 1부터 9까지의 수 1개를 저장할 야구공 객체인 Baseball.

2. Baseball을 List로 가질 일급 컬렉션 객체인 Baseballs.

3. Baseball을 Random하게, 또는 사용자의 입력을 통해 생성할 클래스인 BaseballFactory.

4. 게임이 종료된 후 새로 시작 여부를 저장할 객체인 ResumeOrNot.

5. 이전에 역할을 그대로 수행할 Computer, GameManager, BaseballGame.

6. UI 로직을 담당하여 Static으로 수정한 클래스인 Input, Output.

7. 결과를 계산하여 돌려주는 객체인 Result(기존의 Referee).

### 중점으로 수정을 진행한 부분

1. Baseball 객체로 야구공에 해당하는 숫자 하나를 포장.

   - 처음 생성할 때 유효성 검증을 진행할 수 있어서 코드가 상당히 깔끔해짐.

   - 오버라이딩 연습을 진행해봄.

2. Baseball 객체를 List Collection으로 가지는 일급 컬렉션 객체 Baseballs.

   - 생성된 숫자들을 저장하면서 유효성 검사 동시 진행가능.

   - 3개의 숫자(Baseball)만 저장되도록 검증하면, 이후 스트라이크와 볼의 개수를 구하는 것도 이 객체에서 모두 가능 -> 3개의 공에 대한 확인의 책임은 모두 해당 클래스가 지도록!

   - 역시 eqauls() 오버라이딩을 통해 정답 여부를 쉽게 equals로만 확인 가능.

3. ResumeOrNot 객체로 사용자의 재진행 여부 입력 포장.

   - 원시타입 또는 문자열을 포장함으로서 가장 크게 편해지는 부분은 유효성 검증인듯.

   - 생성하면서 유효하지 않은 객체들은 생성을 막기 때문에 해당 입력이 발행하는 부분마다 유효성 테스트를 진행할 필요가 없어짐.

   - 객체 자체에서 재진행 여부 입력인지 확인하여 boolean으로 반환 가능하기에 모든 코드들이 간결해짐.
