;;; Sierra Script 1.0 - (do not remove this comment)
(script# 720)
(include sci.sh)
(use Main)
(use LLRoom)
(use n940)
(use Sound)
(use User)
(use PicView)
(use Obj)

(public
	rm720 0
)

(local
	theGNewSpeed
	local1
	[local2 5]
	[local7 15]
	[local22 4]
	[local26 10] = [0 1 2 3 4 5 10 20 50 -1]
	local36
	local37
	local38
	local39
	local40
	local41
	local42
	local43
	local44
	local45
	local46
)
(procedure (localproc_020c &tmp temp0 temp1 temp2 [temp3 4])
	(= temp0 0)
	(while (< temp0 5)
		(= [local2 temp0] 1)
		(++ temp0)
	)
	(= temp0 0)
	(while (< temp0 15)
		(= [local7 temp0] (* temp0 10))
		(++ temp0)
	)
	(= temp0 0)
	(while (< temp0 4)
		(= [local22 temp0] (* temp0 10))
		(++ temp0)
	)
	(hand
		eachElementDo: #dispose
		eachElementDo: #perform clearCode
	)
	(deck eachElementDo: #perform clearCode)
	(= local41 0)
	(= temp0 0)
	(while (< temp0 10)
		(= temp1 (= temp2 0))
		(while
		(deck firstTrue: #perform uniqueCode temp1 temp2)
			(if global111
				(Format @temp3 720 2 temp0)
				(= temp1
					(proc940_0
						@temp3
						106
						81
						{2}
						2
						81
						{3}
						3
						81
						{4}
						4
						81
						{5}
						5
						81
						{6}
						6
						81
						{7}
						7
						81
						{8}
						8
						81
						{9}
						9
						106
						81
						{10}
						10
						81
						{Kluk}
						11
						81
						{Královna}
						12
						81
						{Král}
						13
						81
						{Eso}
						14
					)
				)
				(= temp2
					(proc940_0
						@temp3
						106
						81
						{Køížové}
						1
						106
						81
						{Pikové}
						2
						106
						81
						{Kárové}
						3
						106
						81
						{Srdcové}
						4
					)
				)
				(-- temp2)
			else
				(= temp1 (Random 2 14))
				(= temp2 (Random 0 3))
			)
		)
		((deck at: temp0) view: 722 loop: temp2 cel: temp1)
		(++ temp0)
	)
)

(procedure (localproc_03a4 param1 &tmp temp0 temp1)
	(= temp0 (hand at: param1))
	(= temp1 (deck at: local41))
	(dealSound play:)
	(temp0
		view: 722
		setLoop: (temp1 loop?)
		setCel: (temp1 cel?)
		x: (+ 55 (* param1 44))
		y: 50
		init:
	)
	(return (++ local41))
)

(procedure (localproc_03ff &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp0 0)
	(while (< temp0 5)
		(++ [local7 ((hand at: temp0) cel?)])
		(++ [local22 ((hand at: temp0) loop?)])
		(++ temp0)
	)
	(localproc_056f)
	(switch (mod [local7 0] 10)
		(4 (= local36 7))
		(3
			(if (== (mod [local7 1] 10) 2)
				(= local36 6)
			else
				(= local36 3)
			)
		)
		(2
			(cond 
				((== (mod [local7 1] 10) 2) (= local36 2))
				((>= (/ [local7 0] 10) 11) (= local36 1))
				(else (= local36 0))
			)
		)
		(else 
			(Sort hand sortHand sortCode)
			(= temp1 ((sortHand at: 0) cel?))
			(= temp2 ((sortHand at: 4) cel?))
			(= temp3 ((sortHand at: 3) cel?))
			(sortHand release: dispose:)
			(if (and (== temp2 14) (== temp1 2) (== temp3 5))
				(= temp4 1)
			else
				(= temp4 (if (== (- temp2 temp1) 4) 1 else 0))
			)
			(cond 
				((== (mod [local22 0] 10) 5)
					(cond 
						((not temp4) (= local36 5))
						((== temp1 10) (= local36 9))
						(else (= local36 8))
					)
				)
				(temp4 (= local36 4))
				(else (= local36 0))
			)
		)
	)
)

(procedure (localproc_056f &tmp temp0 temp1 temp2 [temp3 100])
	(= temp0 0)
	(while (< temp0 14)
		(= temp1 (+ temp0 1))
		(while (< temp1 15)
			(if
			(> (mod [local7 temp1] 10) (mod [local7 temp0] 10))
				(= temp2 [local7 temp0])
				(= [local7 temp0] [local7 temp1])
				(= [local7 temp1] temp2)
			)
			(++ temp1)
		)
		(++ temp0)
	)
	(= temp0 0)
	(while (< temp0 3)
		(= temp1 (+ temp0 1))
		(while (< temp1 4)
			(if
			(> (mod [local22 temp1] 10) (mod [local22 temp0] 10))
				(= temp2 [local22 temp0])
				(= [local22 temp0] [local22 temp1])
				(= [local22 temp1] temp2)
			)
			(++ temp1)
		)
		(++ temp0)
	)
)

(procedure (localproc_060a)
	(= local39 (- local39 local38))
	(= local40 1)
	(localproc_061b)
)

(procedure (localproc_061b &tmp [temp0 50])
	(Display
		720
		3
		dsCOORD
		60
		25
		dsFONT
		global23
		dsCOLOR
		global128
		dsBACKGROUND
		global122
	)
	(Display 720 4 108 local44)
	(Format @temp0 720 5 local37)
	(= local44
		(Display
			@temp0
			dsCOORD
			80
			25
			dsFONT
			global23
			dsCOLOR
			global128
			dsBACKGROUND
			global122
		)
	)
	(Display 720 4 108 local45)
	(Format @temp0 720 6 local38)
	(= local45
		(Display
			@temp0
			dsCOORD
			153
			25
			dsFONT
			global23
			dsCOLOR
			global128
			dsBACKGROUND
			global122
		)
	)
	(Display 720 4 108 local46)
	(Format @temp0 720 6 local39)
	(= local46
		(Display
			@temp0
			dsCOORD
			242
			25
			dsFONT
			global23
			dsCOLOR
			global128
			dsBACKGROUND
			global122
		)
	)
)

(procedure (localproc_06ed param1)
	(param1 setLoop: -1 play:)
	(User canInput: 0)
	(while local37
		(localproc_061b)
		(if (> local37 10)
			(= local37 (- local37 10))
			(= local39 (+ local39 10))
		else
			(-- local37)
			(++ local39)
		)
		(Wait 0)
		(Wait 10)
	)
	(param1 setLoop: 1)
	(User canInput: 1)
)

(instance rm720 of LLRoom
	(properties
		picture 720
	)
	
	(method (init)
		(proc0_22 1)
		(proc0_3)
		(gIconBar disable: 3 6 7 curIcon: (gIconBar at: 2))
		(gGame setCursor: ((gIconBar curIcon?) cursor?))
		(super init:)
		(= theGNewSpeed gNewSpeed)
		(= gNewSpeed 6)
		(incBet init:)
		(decBet init:)
		(cashout init:)
		(hold1 init:)
		(hold2 init:)
		(hold3 init:)
		(hold4 init:)
		(hold5 init:)
		(deal init:)
		(deck
			add: cardD0 cardD1 cardD2 cardD3 cardD4 cardD5 cardD6 cardD7 cardD8 cardD9
		)
		(hand add: cardH0 cardH1 cardH2 cardH3 cardH4)
		(= local39 global153)
		(= global153 0)
		(if local39 (= local38 1))
		(gLarry put: 17 0)
		(localproc_061b)
		(self setScript: sPlayPoker)
	)
	
	(method (doit)
		(super doit: &rest)
		(if (GameIsRestarting) (localproc_061b))
	)
	
	(method (dispose)
		(hand dispose:)
		(deck dispose:)
		(sortHand dispose:)
		(gIconBar enable: 0 3 6 7)
		(= gNewSpeed theGNewSpeed)
		(super dispose:)
	)
	
	(method (doVerb theVerb &tmp [temp0 200])
		(switch theVerb
			(2
				(Format @temp0 720 0 global163)
				(proc0_14
					@temp0
					80
					{Vítejte v Trampovì kasinu}
					33
					global173
					67
					-1
					15
					70
					260
				)
			)
			(1 (cashout doVerb: 3))
			(else  (proc0_14 720 1))
		)
	)
)

(instance deck of Set
	(properties)
)

(instance hand of Set
	(properties)
)

(instance sortHand of Set
	(properties)
)

(instance sortCode of Code
	(properties)
	
	(method (doit param1 &tmp temp0)
		(if (not (= temp0 (param1 cel?))) (= temp0 13))
		(return temp0)
	)
)

(instance clearCode of Code
	(properties)
	
	(method (doit param1)
		(param1 view: 722 setLoop: 0 setCel: 0)
	)
)

(instance cardH0 of View
	(properties)
)

(instance cardH1 of View
	(properties)
)

(instance cardH2 of View
	(properties)
)

(instance cardH3 of View
	(properties)
)

(instance cardH4 of View
	(properties)
)

(instance cardD0 of View
	(properties)
)

(instance cardD1 of View
	(properties)
)

(instance cardD2 of View
	(properties)
)

(instance cardD3 of View
	(properties)
)

(instance cardD4 of View
	(properties)
)

(instance cardD5 of View
	(properties)
)

(instance cardD6 of View
	(properties)
)

(instance cardD7 of View
	(properties)
)

(instance cardD8 of View
	(properties)
)

(instance cardD9 of View
	(properties)
)

(instance uniqueCode of Code
	(properties)
	
	(method (doit param1 param2 param3)
		(return
			(if (== (param1 loop?) param3)
				(== (param1 cel?) param2)
			else
				0
			)
		)
	)
)

(instance incBet of Prop
	(properties
		x 132
		y 176
		description {tlaèítko Zvýšit}
		lookStr {Kliknutím zde rukou a zvýšíte svou sázku.}
		view 720
	)
	
	(method (init)
		(super init:)
		(gLl5MDHandler addToFront: self)
	)
	
	(method (dispose)
		(gLl5MDHandler delete: self)
		(super dispose:)
	)
	
	(method (handleEvent pEvent &tmp newEvent temp1)
		(if (self onMe: pEvent)
			(if
				(and
					(== (pEvent type?) evMOUSEBUTTON)
					(not (pEvent modifiers?))
					(== gCursorNumber 2)
				)
				(while
					(and
						(!= ((= newEvent (Event new:)) type?) 2)
						(self onMe: newEvent)
					)
					(= temp1 (GetTime))
					(while (< (GetTime) (+ 7 temp1))
					)
					(self doVerb: 3)
					(newEvent dispose:)
				)
				(newEvent dispose:)
				(pEvent claimed: 1)
			else
				(super handleEvent: pEvent)
			)
		else
			(super handleEvent: pEvent)
		)
	)
	
	(method (doVerb theVerb param2 &tmp [temp0 10])
		(switch theVerb
			(3
				(if local43
					(if (< local38 100)
						(cond 
							(local40 (proc0_14 720 7))
							((< local38 local39)
								(buttonSound play:)
								(++ local38)
								(= local37 0)
								(localproc_061b)
							)
							(else (proc0_14 720 8))
						)
					else
						(proc0_14 720 9)
					)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance decBet of Prop
	(properties
		x 175
		y 172
		description {tlaèítko Snížení}
		lookStr {Kliknutím zde rukou snížíte svou sázku.}
		view 720
		loop 1
	)
	
	(method (init)
		(super init:)
		(gLl5MDHandler addToFront: self)
	)
	
	(method (dispose)
		(gLl5MDHandler delete: self)
		(super dispose:)
	)
	
	(method (handleEvent pEvent &tmp newEvent temp1)
		(if (self onMe: pEvent)
			(if
				(and
					(== (pEvent type?) evMOUSEBUTTON)
					(not (pEvent modifiers?))
					(== gCursorNumber 2)
				)
				(while
					(and
						(!= ((= newEvent (Event new:)) type?) 2)
						(self onMe: newEvent)
					)
					(= temp1 (GetTime))
					(while (< (GetTime) (+ 7 temp1))
					)
					(self doVerb: 3)
					(newEvent dispose:)
				)
				(newEvent dispose:)
				(pEvent claimed: 1)
			else
				(super handleEvent: pEvent)
			)
		else
			(super handleEvent: pEvent)
		)
	)
	
	(method (doVerb theVerb param2 &tmp [temp0 10])
		(switch theVerb
			(3
				(if local43
					(cond 
						(local40 (proc0_14 720 7))
						((> local38 1)
							(buttonSound play:)
							(if (and (not (-- local38)) gTheNewDialog)
								(gTheNewDialog dispose:)
							)
							(= local37 0)
							(localproc_061b)
						)
						(else (proc0_14 720 10))
					)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance cashout of View
	(properties
		x 287
		y 151
		description {tlaèítko Vyplatit}
		lookStr {Kliknutím zde rukou ukonèíte hru na tomto automatu. Vaše výhry vám budou automaticky vyplaceny.}
		view 720
		loop 2
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(buttonSound play:)
				(if
					(and
						local43
						(not (& ((gIconBar at: 8) signal?) $0004))
					)
					(self setCel: 1)
					(if local39
						(gLongSong2 number: 723 loop: 1 flags: 1 play:)
						(proc0_14 720 11)
						(= global153 local39)
						(gLarry get: 17)
					)
					(proc0_22 0)
					(global2 newRoom: 710)
				else
					(proc0_14 720 12)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance deal of View
	(properties
		x 29
		y 151
		description {tlaèítko Rozdat}
		sightAngle 40
		lookStr {Kliknutím zde rukou zahájíte novou hru pokeru.}
		view 720
		loop 3
	)
	
	(method (doVerb theVerb param2 &tmp temp0)
		(switch theVerb
			(3
				(if local43
					(buttonSound play:)
					(localproc_061b)
					(if gTheNewDialog (gTheNewDialog dispose:))
					(if local38
						(if (not local40) (++ global163) (localproc_060a))
						(self setCel: 1)
						(= local43 0)
						(= local42 0)
						(sPlayPoker cue:)
					else
						(proc0_14 720 13)
					)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance hold1 of View
	(properties
		x 68
		y 151
		description {tlaèítko Podržet kartu 1}
		sightAngle 40
		lookStr {Kliknutím zde rukou podržíte kartu è. 1.}
		view 720
		loop 4
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(if local42
					(buttonSound play:)
					(if cel
						(= [local2 0] 1)
						(self setCel: 0)
					else
						(= [local2 0] 0)
						(self setCel: 1)
					)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
	
	(method (onMe &tmp temp0)
		(= temp0 (hand at: 0))
		(cond 
			((super onMe: &rest))
			((IsObject temp0) (if (gCast contains: temp0) (temp0 onMe: &rest)))
		)
	)
)

(instance hold2 of View
	(properties
		x 114
		y 151
		description {tlaèítko Podržet kartu 2}
		sightAngle 40
		lookStr {Kliknutím zde rukou podržíte kartu è. 2.}
		view 720
		loop 4
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(if local42
					(buttonSound play:)
					(if cel
						(= [local2 1] 1)
						(self setCel: 0)
					else
						(= [local2 1] 0)
						(self setCel: 1)
					)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
	
	(method (onMe &tmp temp0)
		(= temp0 (hand at: 1))
		(cond 
			((super onMe: &rest))
			((IsObject temp0) (if (gCast contains: temp0) (temp0 onMe: &rest)))
		)
	)
)

(instance hold3 of View
	(properties
		x 159
		y 151
		description {tlaèítko Podržet kartu 3}
		sightAngle 40
		lookStr {Kliknutím zde rukou podržíte kartu è. 3.}
		view 720
		loop 4
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(if local42
					(buttonSound play:)
					(if cel
						(= [local2 2] 1)
						(self setCel: 0)
					else
						(= [local2 2] 0)
						(self setCel: 1)
					)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
	
	(method (onMe &tmp temp0)
		(= temp0 (hand at: 2))
		(cond 
			((super onMe: &rest))
			((IsObject temp0) (if (gCast contains: temp0) (temp0 onMe: &rest)))
		)
	)
)

(instance hold4 of View
	(properties
		x 203
		y 151
		description {tlaèítko Podržet kartu 4}
		sightAngle 40
		lookStr {Kliknutím zde rukou podržíte kartu è. 4.}
		view 720
		loop 4
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(if local42
					(buttonSound play:)
					(if cel
						(= [local2 3] 1)
						(self setCel: 0)
					else
						(= [local2 3] 0)
						(self setCel: 1)
					)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
	
	(method (onMe &tmp temp0)
		(= temp0 (hand at: 3))
		(cond 
			((super onMe: &rest))
			((IsObject temp0) (if (gCast contains: temp0) (temp0 onMe: &rest)))
		)
	)
)

(instance hold5 of View
	(properties
		x 246
		y 151
		description {tlaèítko Podržet kartu 5}
		sightAngle 40
		lookStr {Kliknutím zde rukou podržíte kartu è. 5.}
		view 720
		loop 4
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(if local42
					(buttonSound play:)
					(if cel
						(= [local2 4] 1)
						(self setCel: 0)
					else
						(= [local2 4] 0)
						(self setCel: 1)
					)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
	
	(method (onMe &tmp temp0)
		(= temp0 (hand at: 4))
		(cond 
			((super onMe: &rest))
			((IsObject temp0) (if (gCast contains: temp0) (temp0 onMe: &rest)))
		)
	)
)

(instance dealSound of Sound
	(properties
		number 721
	)
)

(instance buttonSound of Sound
	(properties
		number 722
	)
)

(instance cashOutSound of Sound
	(properties
		number 723
	)
)

(instance winSound of Sound
	(properties
		number 724
		loop -1
	)
)

(instance bigWinSound of Sound
	(properties
		number 724
		loop -1
	)
)

(instance loseSound of Sound
	(properties
		flags $0001
		number 726
	)
)

(instance sPlayPoker of Script
	(properties)
	
	(method (changeState newState &tmp temp0 [temp1 50])
		(switch (= state newState)
			(0
				(= local43 1)
				(gIconBar enable: 8)
			)
			(1
				(localproc_020c)
				(gIconBar disable: 8)
				(= cycles 2)
			)
			(2
				(localproc_03a4 register)
				(= cycles 4)
			)
			(3
				(if (< (++ register) 5) (= state (- state 2)))
				(= cycles 1)
			)
			(4
				(deal setCel: 0)
				(hold1 setCel: 0)
				(hold2 setCel: 0)
				(hold3 setCel: 0)
				(hold4 setCel: 0)
				(hold5 setCel: 0)
				(= local43 1)
				(= local42 1)
			)
			(5
				(= temp0 0)
				(while (< temp0 5)
					(if [local2 temp0] ((hand at: temp0) dispose:))
					(++ temp0)
				)
				(= register 0)
				(= cycles 2)
			)
			(6
				(if [local2 register]
					(localproc_03a4 register)
					(= cycles 4)
				else
					(self cue:)
				)
			)
			(7
				(if (< (++ register) 5) (= state (- state 2)))
				(= cycles 1)
			)
			(8
				(deal setCel: 0)
				(hold1 setCel: 0)
				(hold2 setCel: 0)
				(hold3 setCel: 0)
				(hold4 setCel: 0)
				(hold5 setCel: 0)
				(++ local1)
				(localproc_03ff)
				(if (== local36 9)
					(Format @temp1 720 14 global163)
					(proc0_14
						@temp1
						70
						200
						80
						{Další šastný výherce}
						33
						global26
						30
						1
					)
					(= global153 global163)
					(= global163 1000)
					(gLarry get: 17)
					(proc0_22 0)
					(global2 newRoom: 710)
				else
					(= local37 (* local38 [local26 local36]))
					(localproc_061b)
					(= cycles 5)
				)
			)
			(9
				(if local37
					(localproc_06ed winSound)
				else
					(loseSound play:)
				)
				(= cycles 1)
			)
			(10
				(if (> local38 local39) (= local38 local39))
				(localproc_061b)
				(if local39
					(= local40 (= register 0))
					(self init:)
				else
					(proc0_14 720 15)
					(gIconBar enable: 8)
					(proc0_22 0)
					(global2 newRoom: 710)
				)
			)
		)
	)
)
