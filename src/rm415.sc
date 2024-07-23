;;; Sierra Script 1.0 - (do not remove this comment)
(script# 415)
(include sci.sh)
(use Main)
(use LLRoom)
(use RTRandCycle)
(use n958)
(use PicView)
(use Obj)

(public
	rm415 0
)

(local
	local0
)
(instance rm415 of LLRoom
	(properties
		picture 415
	)
	
	(method (init)
		(proc958_0 128 1415 1416)
		(super init:)
		(self setScript: sCartoon)
	)
	
	(method (dispose)
		(gLongSong fade: 0 15 12 1 self)
		(super dispose:)
	)
)

(instance You of Talker
	(properties
		x 160
		y 180
		nsTop 76
		nsLeft 168
		view 1416
		loop 3
		name "Patti"
	)
	
	(method (init)
		(= mouth pattiMouth)
		(super init: &rest)
	)
)

(instance pattiMouth of Prop
	(properties
		nsLeft 1
		view 1416
		cycleSpeed 5
	)
)

(instance Inspector_Desmond of Talker
	(properties
		x 1
		y 180
		nsTop 73
		nsLeft 120
		view 1415
		loop 3
		talkWidth 160
		name "Inspektor Desmond"
	)
	
	(method (init)
		(= mouth desmondMouth)
		(super init: &rest)
	)
)

(instance desmondMouth of Prop
	(properties
		view 1415
		cycleSpeed 5
	)
)

(instance sCartoon of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_18 Inspector_Desmond 415 0 108 139 self)
			)
			(1 (= ticks 123))
			(2
				(proc0_18 You 415 1 108 139 self)
			)
			(3 (= ticks 123))
			(4
				(proc0_18 Inspector_Desmond 415 2 108 139 self)
			)
			(5 (= ticks 123))
			(6
				(proc0_18 You 415 3 108 139 self)
			)
			(7 (= ticks 123))
			(8
				(proc0_18 Inspector_Desmond 415 4 108 139 self)
			)
			(9 (= ticks 30))
			(10
				(proc0_18 Inspector_Desmond 415 5 108 139 self)
			)
			(11 (= ticks 30))
			(12
				(proc0_18 Inspector_Desmond 415 6 108 139 self)
			)
			(13 (= ticks 30))
			(14
				(proc0_18 Inspector_Desmond 415 7 108 139 self)
			)
			(15 (= ticks 30))
			(16
				(proc0_18 Inspector_Desmond 415 8 108 139 self)
			)
			(17 (= ticks 30))
			(18
				(proc0_18 Inspector_Desmond 415 9 108 139 self)
			)
			(19 (= ticks 30))
			(20
				(proc0_14 415 10 67 -1 185 70 280)
				(proc0_18 You 415 11 108 139 self)
			)
			(21 (= ticks 123))
			(22
				(proc0_18 You 415 12 108 139 self)
			)
			(23 (= ticks 123))
			(24
				(proc0_18 Inspector_Desmond 415 13 108 139 self)
			)
			(25 (= ticks 210))
			(26 (global2 newRoom: 410))
		)
	)
)
