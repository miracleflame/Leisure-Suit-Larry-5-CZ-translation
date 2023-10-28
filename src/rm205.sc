;;; Sierra Script 1.0 - (do not remove this comment)
(script# 205)
(include sci.sh)
(use Main)
(use LLRoom)
(use RTRandCycle)
(use RandCycle)
(use Cycle)
(use PicView)
(use Obj)

(public
	rm205 0
)

(local
	theScript
)
(instance rm205 of LLRoom
	(properties)
	
	(method (init &tmp temp0)
		(super init:)
		(self setScript: sCartoon)
	)
)

(instance sCartoon of Script
	(properties)
	
	(method (init)
		(gLl5KDHandler addToFront: self)
		(gLl5MDHandler addToFront: self)
		(proc0_13 1000 self)
		(gIconBar disable: 8)
		(super init: &rest)
	)
	
	(method (dispose)
		(gLl5KDHandler delete: self)
		(gLl5MDHandler delete: self)
		(gIconBar enable: 8)
		(super dispose:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(DrawPic 1 dpCLOSEREOPEN_LEFT)
				(gGame setCursor: gCursorNumber 1 300 180)
				(switch (++ global172)
					(1
						(global2 picture: 120 curPic: 120)
						(gLongSong2 number: 210 setLoop: -1 play: 127)
						(self setScript: sMobWantsCane self)
					)
					(2
						(global2 picture: 215 curPic: 215)
						(gLongSong2 number: 215 setLoop: -1 play: 127)
						(self setScript: sScruemallGetsCall self)
					)
					(3
						(global2 picture: 220 curPic: 220)
						(gLongSong2 number: 215 setLoop: -1 play: 127)
						(self setScript: sCaneGetsBigGrant self)
					)
					(4
						(global2 picture: 225 curPic: 225)
						(gLongSong2 number: 215 setLoop: -1 play: 127)
						(self setScript: sCaneWorksCongress self)
					)
				)
			)
			(1
				(if script (script caller: 0 dispose:))
				(= theScript self)
				(DrawPic 1 dpCLOSEREOPEN_RIGHT)
				(proc0_25 2 global128 205 0)
				(gLongSong2 fade: 0 15 5 1)
				(gLongSong number: 204 loop: -1 play: 0 fade: 127 15 5 0)
				(= seconds 3)
			)
			(2 (global2 newRoom: 200))
		)
	)
	
	(method (handleEvent pEvent)
		(if (proc999_5 (pEvent type?) 1 4)
			(if theScript (theScript cue:))
		else
			(super handleEvent: pEvent)
		)
	)
)

(instance sMobWantsCane of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= theScript self)
				(proc0_25 4 global128 205 1)
				(= seconds 5)
			)
			(1
				(= theScript 0)
				(DrawPic 120 dpCLOSEREOPEN_LEFT)
				(leftEyebrow init:)
				(rightEyebrow init:)
				(cigar init:)
				(hand init:)
				(= ticks 30)
			)
			(2
				(cigar setCycle: RandCycle)
				(leftEyebrow setCycle: RandCycle)
				(rightEyebrow setCycle: RandCycle)
				(proc0_14 205 2 80 {Mr. Bigg} 108 self 67 -1 185)
			)
			(3
				(cigar setCycle: 0)
				(hand setCycle: Fwd)
				(leftEyebrow setCycle: Beg)
				(rightEyebrow setCycle: Beg)
				(proc0_18 Vinnie 205 3 108 139 self)
			)
			(4 (= ticks 45))
			(5
				(proc0_18 Vinnie 205 4 108 139 self)
			)
			(6 (= ticks 45))
			(7
				(proc0_18 Bruno 205 5 108 139 self)
			)
			(8 (= ticks 45))
			(9
				(proc0_18 Bruno 205 6 108 139 self)
			)
			(10 (= ticks 45))
			(11
				(proc0_18 Bruno 205 7 108 139 self)
			)
			(12
				(proc0_14 205 8)
				(= ticks 45)
			)
			(13
				(leftEyebrow setCycle: RandCycle)
				(rightEyebrow setCycle: RandCycle)
				(hand setCycle: End)
				(cigar setCycle: RandCycle)
				(proc0_14 205 9 80 {Mr. Bigg} 108 self 67 -1 185)
			)
			(14
				(leftEyebrow setCycle: Beg)
				(rightEyebrow setCycle: Beg)
				(hand setCycle: Beg)
				(proc0_14 205 10)
				(= ticks 30)
			)
			(15
				(cigar setCycle: Fwd)
				(proc0_14 205 11 80 {Mr. Bigg} 108 self 67 -1 185)
			)
			(16 (self dispose:))
		)
	)
)

(instance sScruemallGetsCall of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= theScript self)
				(proc0_25 3 global128 205 12)
				(= seconds 5)
			)
			(1
				(= theScript 0)
				(DrawPic 215 dpCLOSEREOPEN_LEFT)
				(= cycles 2)
			)
			(2
				(proc0_14 205 13 67 -1 185 70 280)
				(= ticks 45)
			)
			(3
				(proc0_18 Silas_Scruemall 205 14 108 139 self)
			)
			(4 (= ticks 45))
			(5
				(proc0_18 Silas_Scruemall 205 15 108 139 self)
			)
			(6 (= ticks 30))
			(7 (self dispose:))
		)
	)
)

(instance sCaneGetsBigGrant of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= theScript self)
				(proc0_25 4 global128 205 16)
				(= seconds 5)
			)
			(1
				(= theScript 0)
				(DrawPic 220 dpCLOSEREOPEN_LEFT)
				(= cycles 2)
			)
			(2
				(proc0_18 President_of_C_A_N_E_ 205 17 108 139 self)
			)
			(3 (= ticks 45))
			(4
				(proc0_18 President_of_C_A_N_E_ 205 18 108 139 self)
			)
			(5 (= ticks 45))
			(6
				(proc0_18 Luigi 205 19 108 139 self)
			)
			(7 (= ticks 45))
			(8
				(proc0_18 Luigi 205 20 108 139 self)
			)
			(9 (= ticks 45))
			(10
				(proc0_18 President_of_C_A_N_E_ 205 21 108 139 self)
			)
			(11 (= ticks 45))
			(12
				(proc0_18 Luigi 205 22 108 139 self)
			)
			(13 (= ticks 30))
			(14 (self dispose:))
		)
	)
)

(instance sCaneWorksCongress of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= theScript self)
				(proc0_25 4 global128 205 23)
				(= seconds 7)
			)
			(1
				(= theScript 0)
				(DrawPic 225 dpCLOSEREOPEN_LEFT)
				(= cycles 2)
			)
			(2
				(face init:)
				(arm init: setCycle: End self)
			)
			(3
				(proc0_14
					205
					24
					80
					{Your Elected Official}
					67
					100
					185
					70
					220
				)
				(= ticks 45)
			)
			(4
				(proc0_14
					205
					25
					80
					{Your Elected Official}
					67
					100
					185
					70
					220
				)
				(= ticks 45)
			)
			(5
				(proc0_14
					205
					26
					80
					{Your Elected Official}
					67
					100
					185
					70
					220
				)
				(= ticks 45)
			)
			(6
				(proc0_18 A_C_A_N_E_-er 205 27 108 139 self)
			)
			(7 (= ticks 45))
			(8
				(proc0_18 A_C_A_N_E_-er 205 28 108 139 self)
			)
			(9 (= ticks 45))
			(10
				(proc0_14
					205
					29
					80
					{Your Elected Official}
					67
					100
					185
					70
					220
				)
				(= ticks 30)
			)
			(11 (self dispose:))
		)
	)
)

(instance leftEyebrow of Prop
	(properties
		x 213
		y 57
		view 124
		priority 14
		signal $4010
	)
)

(instance rightEyebrow of Prop
	(properties
		x 227
		y 57
		view 124
		loop 1
		priority 14
		signal $4010
	)
)

(instance cigar of Prop
	(properties
		x 168
		y 87
		view 124
		loop 3
		priority 14
		signal $4010
	)
)

(instance hand of Prop
	(properties
		x 154
		y 149
		view 124
		loop 4
		priority 14
		signal $4010
	)
)

(instance face of Prop
	(properties
		x 221
		y 114
		view 227
		priority 14
		signal $4010
	)
)

(instance arm of Prop
	(properties
		x 155
		y 110
		view 225
		priority 14
		signal $4010
	)
)

(instance Vinnie of Talker
	(properties
		x 1
		y 180
		nsTop 66
		nsLeft 67
		view 1122
		loop 3
		talkWidth 250
	)
	
	(method (init)
		(= mouth mobFlunky1Mouth)
		(super init: &rest)
	)
)

(instance mobFlunky1Mouth of Prop
	(properties
		nsTop 31
		nsLeft 23
		view 1122
	)
)

(instance Bruno of Talker
	(properties
		x 100
		y 180
		nsTop 95
		nsLeft 267
		view 1123
		loop 3
	)
	
	(method (init)
		(= mouth mobFlunky2Mouth)
		(super init: &rest)
	)
)

(instance mobFlunky2Mouth of Prop
	(properties
		view 1123
	)
)

(instance Silas_Scruemall of Talker
	(properties
		x 80
		y 150
		nsTop 48
		nsLeft 173
		view 1215
		loop 3
		talkWidth 160
		name "Silas Scruemall"
	)
	
	(method (init)
		(= bust silasBust)
		(= eyes silasEyes)
		(= mouth silasMouth)
		(super init: &rest)
	)
)

(instance silasBust of View
	(properties
		view 1215
		loop 1
	)
)

(instance silasEyes of Prop
	(properties
		nsTop 1
		nsLeft -2
		view 1215
		loop 2
	)
)

(instance silasMouth of Prop
	(properties
		nsTop 20
		view 1215
	)
)

(instance President_of_C_A_N_E_ of Talker
	(properties
		x 120
		y 160
		nsTop 55
		nsLeft 192
		view 1220
		loop 3
		name "President of C.A.N.E."
	)
	
	(method (init)
		(= bust presBust)
		(= eyes presEyes)
		(= mouth presMouth)
		(super init: &rest)
	)
)

(instance presBust of View
	(properties
		view 1220
		loop 1
	)
)

(instance presEyes of Prop
	(properties
		nsTop 18
		nsLeft 17
		view 1220
		loop 2
	)
)

(instance presMouth of Prop
	(properties
		nsTop 35
		view 1220
	)
)

(instance Luigi of Talker
	(properties
		x 1
		y 160
		nsTop 77
		nsLeft 95
		view 1221
		loop 3
		talkWidth 200
	)
	
	(method (init)
		(= eyes flunkyEyes)
		(= mouth flunkyMouth)
		(super init: &rest)
	)
)

(instance flunkyEyes of Prop
	(properties
		nsTop -7
		nsLeft 1
		view 1221
		loop 2
	)
)

(instance flunkyMouth of Prop
	(properties
		view 1221
	)
)

(instance A_C_A_N_E_-er of Talker
	(properties
		x 1
		y 140
		nsTop 95
		nsLeft 144
		view 1225
		loop 3
		talkWidth 250
		name "A C.A.N.E.-er"
	)
	
	(method (init)
		(= eyes congressEyes)
		(= mouth congressMouth)
		(super init: &rest)
	)
)

(instance congressEyes of Prop
	(properties
		nsTop -10
		nsLeft -61
		view 1225
		loop 2
	)
)

(instance congressMouth of Prop
	(properties
		view 1225
	)
)
