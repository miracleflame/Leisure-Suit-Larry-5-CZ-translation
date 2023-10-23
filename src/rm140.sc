;;; Sierra Script 1.0 - (do not remove this comment)
(script# 140)
(include sci.sh)
(use Main)
(use LLRoom)
(use RTRandCycle)
(use n958)
(use Cycle)
(use PicView)
(use Obj)

(public
	rm140 0
)

(local
	local0
)
(instance rm140 of LLRoom
	(properties
		picture 140
	)
	
	(method (init)
		(proc958_0 128 140 141 1142 1143 1140)
		(proc958_0 132 140)
		(proc0_2)
		(super init:)
		(fScruemall init: setPri: 3)
		(pornGeek1 init:)
		(pornGeek2 init:)
		(geek3 init:)
		(geek4 init:)
		(geek4a init:)
		(geek5 init:)
		(geek6 init:)
		(geek6a init:)
		(geek7 init:)
		(gAddToPics doit:)
		(proc0_13 155)
		(gLongSong number: 140 flags: 1 setLoop: -1 play:)
		(if (== gGNumber 130)
			(self setScript: sCartoon)
		else
			(= style 11)
			(self setScript: sLarryCartoon)
		)
	)
	
	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 160) (gLongSong fade: 0 15 12 1))
		(super newRoom: newRoomNumber)
	)
)

(instance fScruemall of Prop
	(properties
		x 158
		y 55
		view 144
		cel 2
	)
)

(instance pornGeek1 of PicView
	(properties
		x 63
		y 81
		view 142
		priority 7
		signal $0010
	)
)

(instance pornGeek2 of PicView
	(properties
		x 249
		y 75
		view 143
		priority 7
		signal $0010
	)
)

(instance geek3 of PicView
	(properties
		x 53
		y 110
		view 140
		priority 8
	)
)

(instance geek5 of PicView
	(properties
		x 267
		y 114
		view 140
		loop 1
		priority 9
	)
)

(instance geek4 of PicView
	(properties
		x 221
		y 159
		view 140
		loop 2
		cel 1
	)
)

(instance geek4a of PicView
	(properties
		x 236
		y 128
		view 140
		loop 2
		priority 14
		signal $0010
	)
)

(instance geek6 of PicView
	(properties
		x 103
		y 154
		view 140
		loop 3
		cel 1
		priority 13
		signal $0010
	)
)

(instance geek6a of PicView
	(properties
		x 89
		y 126
		view 140
		loop 3
		priority 14
		signal $0010
	)
)

(instance geek7 of PicView
	(properties
		x 157
		y 128
		view 140
		loop 4
	)
)

(instance Biffie of Talker
	(properties
		nsTop 113
		nsLeft 3
		view 1142
		loop 3
		viewInPrint 1
	)
	
	(method (init)
		(= bust geek1Bust)
		(= eyes geek1Eyes)
		(= mouth geek1Mouth)
		(super init: &rest)
	)
)

(instance geek1Bust of Prop
	(properties
		view 1142
		loop 1
	)
)

(instance geek1Eyes of Prop
	(properties
		nsTop 15
		nsLeft 10
		view 1142
		loop 2
		cycleSpeed 70
	)
)

(instance geek1Mouth of Prop
	(properties
		nsTop 36
		nsLeft 26
		view 1142
		cycleSpeed 5
	)
)

(instance Scooter of Talker
	(properties
		nsTop 113
		nsLeft 48
		view 1143
		loop 3
		viewInPrint 1
	)
	
	(method (init)
		(= bust geek2Bust)
		(= eyes geek2Eyes)
		(= mouth geek2Mouth)
		(super init: &rest)
	)
)

(instance geek2Bust of Prop
	(properties
		view 1143
		loop 1
	)
)

(instance geek2Eyes of Prop
	(properties
		nsTop 34
		nsLeft 23
		view 1143
		loop 2
		cycleSpeed 70
	)
)

(instance geek2Mouth of Prop
	(properties
		nsTop 40
		nsLeft 16
		view 1143
		cycleSpeed 5
	)
)

(instance Silas_Scruemall of Talker
	(properties
		nsTop 106
		nsLeft 40
		view 1140
		loop 3
		viewInPrint 1
		name "Silas Scruemall"
	)
	
	(method (init)
		(= bust ScruemallBust)
		(= eyes ScruemallEyes)
		(= mouth ScruemallMouth)
		(super init: &rest)
	)
)

(instance ScruemallBust of Prop
	(properties
		view 1140
		loop 1
	)
)

(instance ScruemallEyes of Prop
	(properties
		nsTop 31
		nsLeft 13
		view 1140
		loop 2
		cycleSpeed 70
	)
)

(instance ScruemallMouth of Prop
	(properties
		nsTop 53
		nsLeft 8
		view 1140
		cycleSpeed 5
	)
)

(instance sCartoon of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_18 Biffie 140 0 108 139 self)
			)
			(1 (= ticks 60))
			(2
				(proc0_18 Biffie 140 1 108 139 self)
			)
			(3 (= ticks 60))
			(4
				(proc0_18 Biffie 140 2 108 139 self)
			)
			(5 (= ticks 60))
			(6
				(proc0_18 Biffie 140 3 108 139 self)
			)
			(7 (= ticks 60))
			(8
				(proc0_18 Biffie 140 4 108 139 self)
			)
			(9 (= ticks 60))
			(10
				(proc0_18 Biffie 140 5 108 139 self)
			)
			(11 (= ticks 60))
			(12
				(proc0_18 Biffie 140 6 108 139 self)
			)
			(13 (= ticks 60))
			(14
				(fScruemall setCel: 1)
				(= seconds 3)
			)
			(15
				(proc0_14 140 7)
				(= seconds 3)
			)
			(16
				(fScruemall setCel: 2)
				(= ticks 100)
			)
			(17
				(proc0_18 Silas_Scruemall 140 8 108 139 self)
			)
			(18 (= ticks 60))
			(19
				(fScruemall setCel: 1)
				(proc0_14 140 9 67 68 91 80 {A Yes Man})
				(proc0_14 140 10 67 105 137 80 {A Yes Man})
				(proc0_14 140 11 67 180 113 80 {A Yes Man})
				(= seconds 3)
			)
			(20
				(proc0_18 Silas_Scruemall 140 12 108 139 self)
			)
			(21 (= ticks 60))
			(22
				(proc0_14 140 9 67 180 147 80 {A Yes Man})
				(proc0_14 140 10 67 0 147 80 {A Yes Man})
				(proc0_14 140 11 67 68 91 80 {A Yes Man})
				(= seconds 3)
			)
			(23
				(proc0_18 Silas_Scruemall 140 13 108 139 self)
			)
			(24 (= ticks 60))
			(25
				(fScruemall setCel: 0)
				(proc0_14 140 9 67 105 137 80 {A Yes Man})
				(proc0_14 140 10 67 180 113 80 {A Yes Man})
				(proc0_14 140 11 67 180 147 80 {A Yes Man})
				(= seconds 3)
			)
			(26
				(proc0_18 Scooter 140 14 108 139 self)
			)
			(27
				(fScruemall setCel: 1)
				(= seconds 3)
			)
			(28
				(proc0_18 Silas_Scruemall 140 15 108 139 self)
			)
			(29 (= ticks 60))
			(30
				(proc0_14 140 16 67 0 147 80 {A Yes Man})
				(proc0_14 140 17 67 68 91 80 {A Yes Man})
				(proc0_14 140 18 67 105 137 80 {A Yes Man})
				(fScruemall setCel: 0)
				(= seconds 4)
			)
			(31
				(proc0_18 Scooter 140 19 108 139 self)
			)
			(32
				(fScruemall setCel: 0)
				(= ticks 150)
			)
			(33
				(gIconBar disable:)
				(DrawPic 1 -32762)
				(= seconds 3)
			)
			(34
				(gIconBar enable:)
				(global2 newRoom: 160)
			)
		)
	)
)

(instance sLarryCartoon of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(fScruemall setCel: 1)
				(gLarry
					init:
					x: 319
					y: 69
					view: 141
					setCycle: Walk
					loop: 1
					setMotion: MoveTo 217 56 self
				)
			)
			(1
				(proc0_18 gLarry 140 20)
				(= cycles 10)
			)
			(2
				(proc0_18 Silas_Scruemall 140 21 108 139 self)
			)
			(3
				(proc0_14 140 22 67 -1 185)
				(gLarry setMotion: MoveTo 190 53 self)
			)
			(4
				(gLarry setMotion: MoveTo 125 53 self)
			)
			(5
				(fScruemall setCel: 2)
				(gLarry setCel: 0 y: 55 setLoop: 2 setCycle: End self)
			)
			(6
				(proc0_18 gLarry 140 23)
				(global2 newRoom: 150)
			)
		)
	)
)
