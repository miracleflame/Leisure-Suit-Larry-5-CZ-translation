;;; Sierra Script 1.0 - (do not remove this comment)
(script# 295)
(include sci.sh)
(use Main)
(use LLRoom)
(use RTRandCycle)
(use Polygon)
(use ForwardCounter)
(use Timer)
(use Cycle)
(use PicView)
(use Obj)

(public
	rm295 0
)

(local
	local0
	local1
	local2
	local3
	local4
)
(procedure (localproc_1308)
	(switch (Random 0 1)
		(0
			(flash posn: (Random 73 112) (Random 110 151))
		)
		(1
			(flash posn: (Random 192 248) (Random 95 137))
		)
	)
	(flash setCycle: End)
)

(instance rm295 of LLRoom
	(properties
		picture 290
	)
	
	(method (init)
		(gLarry
			init:
			normalize: 291
			setCycle: 0
			setLoop: 5
			setCel: 0
			posn: 152 94
			cycleSpeed: 10
		)
		(super init:)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						94
						144
						110
						145
						90
						163
						75
						161
						69
						167
						74
						174
						109
						189
						0
						189
						0
						0
						319
						0
						319
						189
						202
						189
						232
						169
						249
						165
						249
						157
						211
						141
						98
						140
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 210 152 221 160 218 166 193 167 176 161 179 155 191 154
					yourself:
				)
		)
		(crowd init:)
		(phoneArm init:)
		(takePicRight init:)
		(girlReporter init:)
		(fatReporter init:)
		(videoCameraMan init:)
		(takePicRight init:)
		(lightLeft init:)
		(lightRight init:)
		(cameraFlasher init:)
		(cameraMan init:)
		(kid init:)
		(gAddToPics doit:)
		(Load rsPIC 1)
		(gLongSong
			number: 294
			flags: 1
			setLoop: -1
			play: 0
			fade: 127 15 12 0
		)
		(proc0_2)
		(self setScript: sJetWay)
	)
)

(instance sJetWay of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (and (IsObject flash) (not (Random 0 5)))
			(localproc_1308)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= ticks 60))
			(1
				(gLarry cycleSpeed: 9 setCycle: End self)
			)
			(2
				(proc0_14 295 0 67 -1 20 108)
				(gLarry normalize: posn: 151 121 setHeading: 180)
				(= ticks 60)
			)
			(3
				(proc0_14 295 1 67 -1 185 108)
				(lightLeft setCycle: End)
				(lightRight setCycle: End)
				(kid cue:)
				(flash init:)
				(= ticks 30)
			)
			(4
				(cameraMan cue:)
				(fatReporter cue:)
				(videoCameraMan cue:)
				(cameraFlasher cue:)
				(= ticks 70)
			)
			(5
				(proc0_14 295 2 67 -1 185 70 280 108 self)
			)
			(6 (= ticks 60))
			(7
				(proc0_14 295 3 67 -1 20 108)
				(gLarry
					normalize:
					posn: 152 123
					loop: 2
					cycleSpeed: 7
					moveSpeed: 7
					setMotion: MoveTo 152 131 self
				)
			)
			(8
				(proc0_14 295 4 67 -1 185 108)
				(gLarry setMotion: MoveTo 152 140 self)
			)
			(9 (= ticks 90))
			(10
				(proc0_14 295 5 67 -1 20 108 self)
			)
			(11 (= ticks 60))
			(12
				(proc0_14 295 6 67 -1 20 108 self)
			)
			(13 (= ticks 30))
			(14
				(proc0_14 295 6 67 -1 20 108 self)
			)
			(15 (= ticks 30))
			(16
				(proc0_14 295 0 67 -1 185 108 self)
			)
			(17 (= ticks 30))
			(18
				(proc0_14 295 1 67 -1 185 108 self)
			)
			(19
				(girlReporter setCycle: End self)
			)
			(20 (= ticks 90))
			(21
				(proc0_14 295 7 67 -1 20 108 self)
			)
			(22 (= ticks 30))
			(23
				(proc0_14 295 8 67 -1 185 108 self)
			)
			(24 (= ticks 30))
			(25
				(proc0_14 295 9 67 -1 20 108 self)
			)
			(26 (= ticks 30))
			(27
				(proc0_14 295 10 67 -1 185 108 self)
			)
			(28 (= ticks 30))
			(29
				(proc0_14 295 11 67 -1 20 108 self)
			)
			(30 (= seconds 3))
			(31
				(proc0_14 295 12 67 -1 185 108 self)
			)
			(32 (= ticks 30))
			(33
				(proc0_14 295 13 67 -1 185 108 self)
			)
			(34
				(gLarry setMotion: MoveTo 160 170 self)
			)
			(35
				(proc0_14 295 14 67 -1 185 108 self)
			)
			(36 (= ticks 30))
			(37
				(phoneArm setCycle: End self)
			)
			(38
				(gLarry
					view: 295
					setLoop: 2
					setCel: 0
					cycleSpeed: 10
					setCycle: CT 2 1 self
				)
			)
			(39
				(phoneArm dispose:)
				(gLarry setCycle: End self)
			)
			(40
				(gLarry setLoop: 3 cycleSpeed: 6)
				(self setScript: sTalk)
			)
			(41
				(proc0_14 295 15 67 -1 15 70 280 108 self)
			)
			(42
				(proc0_14 295 16 67 -1 185)
				(global2 drawPic: 1 6)
				(gLongSong fade: 0 15 12 1)
				(= seconds 3)
			)
			(43
				(proc0_14 295 17)
				(proc0_14 295 18)
				(global2 newRoom: 460)
			)
		)
	)
)

(instance sTalk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLarry setCycle: ForwardCounter 2)
				(proc0_18 gLarry 295 19 67 -1 185 108 self)
			)
			(1
				(gLarry setCycle: 0)
				(proc0_18 Mr__President 295 20 108 139 self)
			)
			(2
				(gLarry setCycle: ForwardCounter 5)
				(proc0_18 gLarry 295 21 67 -1 185 108 self)
			)
			(3
				(gLarry setCycle: 0)
				(proc0_18 Mr__President 295 22 108 139 self)
			)
			(4 (= ticks 30))
			(5
				(proc0_18 Mr__President 295 23 108 139 self)
			)
			(6 (= ticks 30))
			(7
				(proc0_18 Mr__President 295 24 108 139 self)
			)
			(8 (= ticks 30))
			(9
				(proc0_18 Mr__President 295 25 108 139 self)
			)
			(10 (= ticks 30))
			(11
				(proc0_18 Mr__President 295 26 108 139 self)
			)
			(12 (= ticks 30))
			(13
				(proc0_18 Mr__President 295 27 108 139 self)
			)
			(14 (= ticks 30))
			(15
				(proc0_18 Mr__President 295 28 108 139 self)
			)
			(16 (= ticks 30))
			(17
				(gLarry setCycle: ForwardCounter 6)
				(proc0_18 gLarry 295 29 67 -1 185 108 self)
			)
			(18
				(gLarry setCycle: 0)
				(proc0_14 295 30 67 -1 185 108 self)
			)
			(19
				(gLarry setCycle: ForwardCounter 6)
				(proc0_18 gLarry 295 31 67 -1 185 108 self)
			)
			(20
				(gLarry setCycle: 0)
				(proc0_18 Mr__President 295 32 108 139 self)
			)
			(21 (= ticks 30))
			(22
				(proc0_18 Mr__President 295 33 108 139 self)
			)
			(23 (= ticks 30))
			(24
				(proc0_18 Mr__President 295 34 108 139 self)
			)
			(25
				(proc0_14 295 35 67 -1 185 108 self)
			)
			(26
				(gLarry setCycle: ForwardCounter 5)
				(proc0_18 gLarry 295 36 67 -1 185 108 self)
			)
			(27
				(gLarry setCycle: 0)
				(client cue:)
			)
		)
	)
)

(instance videoCameraMan of Prop
	(properties
		x 116
		y 144
		view 297
		loop 2
		cel 8
		priority 13
		signal $4010
		cycleSpeed 13
	)
	
	(method (cue)
		(switch (++ local2)
			(1 (self setCycle: Beg self))
			(2
				((Timer new:) setReal: self 5)
			)
			(3 (self setCycle: End self))
			(4
				(= local2 0)
				((Timer new:) setReal: self (Random 5 7))
			)
		)
	)
)

(instance cameraFlasher of Prop
	(properties
		x 184
		y 129
		view 297
		loop 1
		priority 13
		signal $4010
	)
	
	(method (cue)
		(switch (++ local0)
			(1 (self setCycle: End self))
			(2
				(self setCel: 0)
				(self cue:)
			)
			(3
				(= local0 0)
				((Timer new:) setReal: self (Random 3 5))
			)
		)
	)
)

(instance cameraMan of Prop
	(properties
		x 117
		y 135
		view 297
		loop 3
		priority 13
		signal $4010
		cycleSpeed 10
	)
	
	(method (cue)
		(switch (++ local3)
			(1 (self setCycle: End self))
			(2
				((Timer new:) setReal: self 2)
			)
			(3 (self setCycle: Beg self))
			(4
				(= local3 0)
				((Timer new:) setReal: self (Random 2 3))
			)
		)
	)
)

(instance takePicRight of PicView
	(properties
		x 203
		y 135
		view 297
		loop 4
		priority 13
		signal $4011
	)
)

(instance fatReporter of Prop
	(properties
		x 197
		y 137
		view 297
		loop 5
		priority 13
		signal $4010
		cycleSpeed 15
	)
	
	(method (cue)
		(switch (++ local4)
			(1 (self setCycle: End self))
			(2 (self setCycle: Beg self))
			(3
				(= local4 0)
				((Timer new:) setReal: self (Random 2 4))
			)
		)
	)
)

(instance kid of Prop
	(properties
		x 179
		y 133
		view 297
		loop 6
		priority 13
		signal $4010
		cycleSpeed 10
	)
	
	(method (cue)
		(switch (++ local1)
			(1 (self setCycle: End self))
			(2
				(self setCel: 0)
				(self cue:)
			)
			(3 (self setCycle: End self))
			(4
				(self setCel: 0)
				(self cue:)
			)
			(5
				(= local1 0)
				((Timer new:) setReal: self (Random 2 4))
			)
		)
	)
)

(instance girlReporter of Prop
	(properties
		x 200
		y 163
		view 297
		loop 7
		priority 14
		signal $4011
		cycleSpeed 10
	)
)

(instance phoneArm of Prop
	(properties
		x 127
		y 154
		view 295
		priority 12
		signal $4011
		cycleSpeed 10
	)
)

(instance flash of Prop
	(properties
		view 295
		loop 1
		priority 14
		signal $4010
	)
)

(instance crowd of PicView
	(properties
		x 163
		y 159
		view 297
		signal $4001
	)
)

(instance lightLeft of Prop
	(properties
		x 91
		y 77
		view 297
		loop 8
		priority 14
		signal $0010
		cycleSpeed 10
	)
)

(instance lightRight of Prop
	(properties
		x 207
		y 76
		view 297
		loop 9
		priority 14
		signal $0010
		cycleSpeed 10
	)
)

(instance Mr__President of Talker
	(properties
		nsTop 15
		nsLeft 35
		view 1295
		loop 3
		viewInPrint 1
		name "Pan Prezident"
	)
	
	(method (init)
		(= bust bushBust)
		(= eyes bushEyes)
		(= mouth bushMouth)
		(super init: &rest)
	)
)

(instance bushBust of Prop
	(properties
		view 1295
		loop 1
	)
)

(instance bushEyes of Prop
	(properties
		nsTop 28
		nsLeft 30
		view 1295
		loop 2
		cycleSpeed 70
	)
)

(instance bushMouth of Prop
	(properties
		nsTop 31
		nsLeft 24
		view 1295
		cycleSpeed 5
	)
)
