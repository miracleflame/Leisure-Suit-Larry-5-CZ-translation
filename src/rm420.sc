;;; Sierra Script 1.0 - (do not remove this comment)
(script# 420)
(include sci.sh)
(use Main)
(use LLRoom)
(use RTRandCycle)
(use n958)
(use PicView)
(use Obj)

(public
	rm420 0
)

(instance rm420 of LLRoom
	(properties
		picture 420
	)
	
	(method (init)
		(super init:)
		(proc958_0 128 1420 1421)
		(gLongSong number: 425 loop: -1 flags: 1 play:)
		(self setScript: sRoom)
	)
)

(instance sRoom of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= ticks 123))
			(1
				(proc0_18 Inspector_Desmond 420 0 108 139 self)
			)
			(2 (= ticks 60))
			(3
				(proc0_18 You 420 1 108 139 self)
			)
			(4 (= ticks 60))
			(5
				(proc0_18 Inspector_Desmond 420 2 108 139 self)
			)
			(6 (= ticks 60))
			(7
				(proc0_18 Inspector_Desmond 420 3 108 139 self)
			)
			(8 (= ticks 60))
			(9
				(proc0_18 gLarry 420 4)
				(= ticks 60)
			)
			(10
				(proc0_18 You 420 5 108 139 self)
			)
			(11 (= ticks 60))
			(12
				(proc0_18 Inspector_Desmond 420 6 108 139 self)
			)
			(13 (= ticks 60))
			(14
				(proc0_18 Inspector_Desmond 420 7 108 139 self)
			)
			(15 (= ticks 60))
			(16
				(proc0_18 Inspector_Desmond 420 8 108 139 self)
			)
			(17 (= ticks 60))
			(18
				(proc0_18 Inspector_Desmond 420 9 108 139 self)
			)
			(19 (= ticks 60))
			(20
				(proc0_18 gLarry 420 10)
				(= ticks 60)
			)
			(21
				(proc0_18 You 420 11 108 139 self)
			)
			(22 (= ticks 60))
			(23
				(proc0_18 Inspector_Desmond 420 12 108 139 self)
			)
			(24 (= ticks 60))
			(25
				(proc0_18 Inspector_Desmond 420 13 108 139 self)
			)
			(26 (= ticks 60))
			(27
				(proc0_18 Inspector_Desmond 420 14 108 139 self)
			)
			(28 (= ticks 60))
			(29
				(proc0_18 You 420 15 108 139 self)
			)
			(30 (= ticks 60))
			(31
				(proc0_18 Inspector_Desmond 420 16 108 139 self)
			)
			(32 (= ticks 60))
			(33
				(proc0_18 Inspector_Desmond 420 17 108 139 self)
			)
			(34 (= ticks 60))
			(35
				(proc0_18 You 420 18 108 139 self)
			)
			(36 (= ticks 60))
			(37
				(proc0_18 Inspector_Desmond 420 19 108 139 self)
			)
			(38 (= ticks 60))
			(39
				(proc0_18 You 420 20 108 139 self)
			)
			(40 (= ticks 60))
			(41
				(proc0_18 Inspector_Desmond 420 21 108 139 self)
			)
			(42
				(if gTheNewDialog (gTheNewDialog dispose:))
				(gLongSong fade:)
				(global2 newRoom: 430)
			)
		)
	)
)

(instance Inspector_Desmond of Talker
	(properties
		y 160
		nsTop 29
		nsLeft 115
		view 1420
		loop 3
		talkWidth 200
		name "Inspector Desmond"
	)
	
	(method (init)
		(= bust desmondBust)
		(= mouth desmondMouth)
		(super init: &rest)
	)
)

(instance desmondBust of Prop
	(properties
		view 1420
		loop 1
	)
)

(instance desmondMouth of Prop
	(properties
		nsTop 13
		view 1420
		cycleSpeed 8
	)
)

(instance You of Talker
	(properties
		x 140
		y 170
		nsTop 59
		nsLeft 199
		view 1421
		loop 3
	)
	
	(method (init)
		(= mouth pattiMouth)
		(super init: &rest)
	)
)

(instance pattiMouth of Prop
	(properties
		view 1421
		cycleSpeed 8
	)
)
