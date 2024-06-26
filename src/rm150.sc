;;; Sierra Script 1.0 - (do not remove this comment)
(script# 150)
(include sci.sh)
(use Main)
(use LLRoom)
(use RTRandCycle)
(use n958)
(use Sound)
(use Cycle)
(use PicView)
(use Obj)

(public
	rm150 0
)

(local
	local0
)
(instance rm150 of LLRoom
	(properties
		picture 145
	)
	
	(method (init)
		(proc958_0 128 145 146 1151 1145 1150 1215)
		(proc958_0 132 140 150 146 147)
		(proc0_2)
		(fScruemall init:)
		(pArm init:)
		(pLarry init:)
		(super init:)
		(proc0_13 155)
		(self setScript: sCartoon)
	)
	
	(method (dispose)
		(super dispose: &rest)
		(gLongSong fade: 0 15 12 1)
	)
)

(instance fScruemall of Prop
	(properties
		x 153
		y 139
		view 145
		priority 10
		signal $0010
	)
)

(instance fScruemallTopHalf of Prop
	(properties
		x 179
		y 95
		view 145
		loop 1
		priority 10
		signal $0010
	)
)

(instance pLarry of Prop
	(properties
		x 96
		y 107
		view 146
		priority 9
		signal $0010
		cycleSpeed 12
	)
)

(instance pArm of Prop
	(properties
		x 96
		y 109
		view 146
		loop 1
		priority 15
		signal $0010
		cycleSpeed 12
	)
)

(instance light of Prop
	(properties
		x 200
		y 26
		view 145
		loop 2
		priority 15
		signal $0010
	)
)

(instance larryCam of View
	(properties
		x 147
		y 170
		view 150
	)
)

(instance Ty of Talker
	(properties
		nsTop 88
		nsLeft 64
		view 1151
		loop 3
		talkWidth 314
	)
	
	(method (init)
		(= mouth You_b)
		(super init: &rest)
	)
)

(instance You_b of Prop
	(properties
		view 1151
		cycleSpeed 5
	)
)

(instance Silas_Scruemall of Talker
	(properties
		x -1
		y 185
		nsTop 21
		nsLeft 154
		view 1150
		loop 3
		talkWidth 240
		name "Silas Scruemall"
	)
	
	(method (init)
		(= mouth Silas_Scruemall_b)
		(= bust bossmallBust)
		(= eyes bossmallEyes)
		(super init: &rest)
	)
)

(instance bossmallBust of Prop
	(properties
		view 1150
		loop 1
	)
)

(instance bossmallEyes of Prop
	(properties
		nsTop 31
		nsLeft 16
		view 1150
		loop 2
		cycleSpeed 70
	)
)

(instance Silas_Scruemall_b of Prop
	(properties
		nsTop 55
		nsLeft 6
		view 1150
		cycleSpeed 5
		name "Silas Scruemall"
	)
)

(instance Silas_Scruemall_ of Talker
	(properties
		x -1
		y 185
		nsTop 27
		nsLeft 167
		view 1145
		loop 3
		talkWidth 280
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
		view 1145
		loop 1
	)
)

(instance ScruemallEyes of Prop
	(properties
		nsTop 15
		nsLeft 10
		view 1145
		loop 2
		cycleSpeed 70
	)
)

(instance ScruemallMouth of Prop
	(properties
		nsLeft 5
		view 1145
		cycleSpeed 5
	)
)

(instance breakPot of Sound
	(properties
		flags $0001
		number 146
	)
)

(instance yeow of Sound
	(properties
		flags $0001
		number 147
	)
)

(instance plink of Sound
	(properties
		flags $0001
		number 148
	)
)

(instance sCartoon of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 3))
			(1
				(fScruemall setCycle: CT 1 1 self)
			)
			(2
				(pLarry setCycle: End)
				(pArm setCycle: End)
				(fScruemall setCycle: End self)
				(breakPot play:)
			)
			(3
				(yeow play:)
				(proc0_14 150 0 67 -1 185)
				(= seconds 3)
			)
			(4
				(fScruemall setCel: 0 setLoop: 3 stopUpd:)
				(fScruemallTopHalf init: stopUpd:)
				(= ticks 10)
			)
			(5
				(proc0_18 Silas_Scruemall_ 150 1 108 139 self)
			)
			(6 (= ticks 123))
			(7
				(proc0_18 Silas_Scruemall_ 150 2 108 139 self)
			)
			(8 (= ticks 123))
			(9
				(fScruemallTopHalf
					startUpd:
					cycleSpeed: 12
					setCycle: End self
				)
				(plink play:)
				(light init: cycleSpeed: 24 setCycle: End)
			)
			(10 (= ticks 60))
			(11
				(proc0_14 150 3 80 {Silas Scruemall} 67 -1 185 108)
				(= seconds 5)
			)
			(12
				(pLarry dispose:)
				(fScruemall dispose:)
				(fScruemallTopHalf dispose:)
				(pArm dispose:)
				(light dispose:)
				(global2 style: 7 drawPic: 150 picture: 150 curPic: 150)
				(gLongSong number: 150 flags: 1 setLoop: -1 play:)
				(proc0_18 Silas_Scruemall 150 4 108 139 self)
			)
			(13 (= ticks 30))
			(14
				(proc0_18 Silas_Scruemall 150 5 108 139 self)
			)
			(15 (= ticks 123))
			(16
				(proc0_18 Ty 150 6 108 139 self)
			)
			(17 (= ticks 123))
			(18
				(proc0_18 Silas_Scruemall 150 7 108 139 self)
			)
			(19 (= ticks 30))
			(20
				(proc0_18 Silas_Scruemall 150 8 108 139 self)
			)
			(21 (= ticks 123))
			(22
				(proc0_18 Ty 150 9 108 139 self)
			)
			(23 (= ticks 30))
			(24
				(proc0_14 150 10 67 -1 185)
				(= seconds 3)
			)
			(25
				(proc0_18 Silas_Scruemall 150 11 108 139 self)
			)
			(26 (= ticks 30))
			(27
				(proc0_18 Silas_Scruemall 150 12 108 139 self)
			)
			(28 (= ticks 30))
			(29
				(proc0_14 150 13 67 -1 185)
				(= seconds 3)
			)
			(30
				(proc0_18 Silas_Scruemall 150 14 108 139 self)
			)
			(31 (= ticks 123))
			(32
				(proc0_18 Ty 150 15 108 139 self)
			)
			(33 (= ticks 30))
			(34
				(proc0_14 150 16)
				(= seconds 3)
			)
			(35
				(proc0_18 Silas_Scruemall 150 17 108 139 self)
			)
			(36 (= ticks 30))
			(37
				(proc0_18 Silas_Scruemall 150 18 108 139 self)
			)
			(38
				(larryCam init:)
				(proc0_10 1 79)
				(= ticks 123)
			)
			(39
				(proc0_18 Ty 150 19 108 139 self)
			)
			(40 (= seconds 3))
			(41
				(proc0_18 Silas_Scruemall 150 20 108 139 self)
			)
			(42 (= ticks 123))
			(43
				(Ty talkWidth: 160)
				(proc0_18 Ty 150 21 108 139 self)
			)
			(44 (= seconds 3))
			(45
				(proc0_18 Silas_Scruemall 150 22 108 139 self)
			)
			(46 (= ticks 123))
			(47
				(larryCam dispose:)
				(Ty talkWidth: 240)
				(proc0_18 Ty 150 23 108 139 self)
			)
			(48 (= seconds 3))
			(49
				(proc0_18 Silas_Scruemall 150 24 108 139 self)
			)
			(50 (= ticks 30))
			(51
				(proc0_14 150 25 67 -1 20)
				(Ty talkWidth: 240)
				(proc0_18 Ty 150 26 108 139 self)
			)
			(52 (= ticks 123))
			(53
				(proc0_18 Silas_Scruemall 150 27 108 139 self)
			)
			(54 (= ticks 30))
			(55
				(proc0_18 Silas_Scruemall 150 28 108 139 self)
			)
			(56 (= ticks 123))
			(57
				(proc0_14 150 29 67 -1 20)
				(proc0_18 Silas_Scruemall 150 30 108 139 self)
				(proc0_7 7)
			)
			(58 (= ticks 123))
			(59
				(DrawPic 1 -32762)
				(= seconds 3)
			)
			(60
				(proc0_14 150 31)
				(= seconds 3)
			)
			(61
				(proc0_14 150 32 67 -1 185)
				(global2 newRoom: 155)
			)
		)
	)
)
