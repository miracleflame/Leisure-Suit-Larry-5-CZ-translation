;;; Sierra Script 1.0 - (do not remove this comment)
(script# 660)
(include sci.sh)
(use Main)
(use LLRoom)
(use RTRandCycle)
(use PolyPath)
(use Polygon)
(use CueObj)
(use n958)
(use Rev)
(use Timer)
(use Sound)
(use Cycle)
(use User)
(use PicView)
(use Obj)

(public
	rm660 0
)

(local
	local0
	local1 =  1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	[local10 18] = [0 2 4 5 7 9 11 12 14 16 17 19 21 23 24 26 28 29]
)
(procedure (localproc_2850 param1)
	(keyboard
		at:
			(switch (param1 message?)
				(97 30)
				(119 29)
				(115 28)
				(101 27)
				(100 26)
				(102 25)
				(116 24)
				(103 23)
				(121 22)
				(104 21)
				(117 20)
				(106 19)
				(107 18)
				(111 17)
				(108 16)
				(112 15)
				(59 14)
				(39 13)
				(93 12)
				(65 18)
				(87 17)
				(83 16)
				(69 15)
				(68 14)
				(70 13)
				(84 12)
				(71 11)
				(89 10)
				(72 9)
				(85 8)
				(74 7)
				(75 6)
				(79 5)
				(76 4)
				(80 3)
				(58 2)
				(34 1)
				(125 0)
				(else  -1)
			)
	)
)

(procedure (localproc_2a2d param1 &tmp temp0 temp1)
	(= temp0 (- 30 [local10 (/ (param1 x?) 18)]))
	(return
		(cond 
			((> (param1 y?) 180) (return (keyboard at: temp0)))
			(
				(and
					(< temp0 30)
					(not ((= temp1 (keyboard at: (+ temp0 1))) white?))
					(temp1 onMe: param1)
				)
				(return temp1)
			)
			(
				(and
					temp0
					(not ((= temp1 (keyboard at: (- temp0 1))) white?))
					(temp1 onMe: param1)
				)
				(return temp1)
			)
			((> (param1 y?) 164) (return (keyboard at: temp0)))
			(else (return 0))
		)
	)
)

(instance rm660 of LLRoom
	(properties
		picture 660
		south 640
	)
	
	(method (init)
		(gLarry init: normalize: 570)
		(proc0_3)
		(switch gGNumber
			(south
				(gLarry posn: 292 250)
				(if (proc0_6 19)
					(global2 setScript: sWalkIn)
				else
					(global2 setScript: sEntersRoom)
				)
			)
			(else 
				(gLarry posn: 160 160 edgeHit: 0)
			)
		)
		(proc958_0 129 670 1)
		(proc958_0 128 670 672 673 681 682 683 1672)
		(proc958_0 132 660 661 662 663 664 665)
		(super init:)
		(door init:)
		(reverseBiaz init:)
		(synth init: approachVerbs: 3)
		(musicStands init:)
		(recordingBooth init:)
		(overhangingMike init:)
		(drums init:)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						0
						0
						319
						0
						319
						189
						301
						189
						301
						187
						314
						187
						314
						170
						292
						155
						301
						144
						290
						143
						269
						144
						244
						138
						237
						137
						227
						117
						233
						104
						248
						104
						250
						99
						230
						93
						196
						108
						132
						93
						123
						83
						81
						83
						3
						154
						3
						176
						30
						176
						52
						166
						86
						175
						190
						187
						205
						187
						247
						172
						274
						187
						274
						189
						0
						189
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 77 107 103 106 112 112 154 112 154 119 114 122 113 138 65 139
					yourself:
				)
				((Polygon new:)
					type: 2
					init:
						154
						140
						167
						131
						223
						130
						233
						142
						294
						165
						268
						177
						218
						158
						206
						161
						191
						159
						180
						164
						165
						156
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 159 116 196 116 188 130 149 130
					yourself:
				)
		)
	)
	
	(method (dispose)
		(if (not (keyboard isEmpty:)) (keyboard dispose:))
		(gLongSong2 fade: 0 15 12 1)
		(super dispose: &rest)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(if (== curPic 670)
					(if local2 (proc0_14 660 0) else (proc0_14 660 1))
				else
					(proc0_14 660 2)
				)
			)
			(3
				(if (and (== curPic 670) (not local2))
					(proc0_14 660 3)
				else
					(super doVerb: theVerb param2 &rest)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance sEntersRoom of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(proc0_7 19)
				(= cycles 1)
			)
			(1
				(gLarry setMotion: MoveTo 292 182 self)
			)
			(2 (= seconds 2))
			(3
				(proc0_14 660 4)
				(proc0_14 660 5)
				(= seconds 2)
			)
			(4
				(proc0_18 Reverse_Biaz 660 6 108 139 self)
			)
			(5 (proc0_3) (= seconds 3))
			(6
				(proc0_2)
				(proc0_18 Reverse_Biaz 660 7 108 139 self)
			)
			(7
				(proc0_3)
				(gLarry setLoop: -1)
				(reverseBiaz setCel: 0 setCycle: End self)
			)
			(8
				(reverseBiaz setCel: 0)
				(gLarry setScript: sReverseReminds)
				(self dispose:)
			)
		)
	)
)

(instance sWalkIn of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_2) (= cycles 1))
			(1
				(gLarry setMotion: MoveTo 292 182 self)
			)
			(2
				(proc0_3)
				(gLarry setScript: sReverseReminds)
				(self dispose:)
			)
		)
	)
)

(instance sReverseReminds of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 30))
			(1
				(= state (- state 2))
				(proc0_18 Reverse_Biaz 660 8 108 139 self)
			)
			(2 (self dispose:))
		)
	)
)

(instance sUsesSynth of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry setHeading: 90)
				(= seconds 2)
			)
			(1
				(gCast eachElementDo: #hide)
				(global2 drawPic: 670)
				(gIconBar disable: 0)
				(reverseBiaz
					view: 672
					setLoop: 0
					setCel: 0
					x: 203
					y: 72
					setPri: 2
					show:
				)
				(reelOne init:)
				(reelTwo init:)
				(reelThree init:)
				(reelFour init:)
				(vuMeter init:)
				(keyboard init:)
				(music init:)
				(synthPanel init:)
				(panelExtender init:)
				(controlPanel init:)
				(controlPanel2 init:)
				(synth dispose:)
				(musicStands dispose:)
				(recordingBooth dispose:)
				(overhangingMike dispose:)
				(drums dispose:)
				(= cycles 2)
			)
			(2
				(gLarry setScript: sSession)
				(self dispose:)
			)
		)
	)
)

(instance sReturnFromSynth of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(global2 drawPic: (global2 picture?))
				(gCast eachElementDo: #show)
				(reverseBiaz hide:)
				(vuMeter hide:)
				(reelOne hide:)
				(reelTwo hide:)
				(reelThree hide:)
				(reelFour hide:)
				(keyboard dispose:)
				(music dispose:)
				(synthPanel dispose:)
				(panelExtender hide:)
				(door show:)
				(gLarry normalize: 570)
				(global2 setScript: sEnterBooth)
				(self dispose:)
			)
		)
	)
)

(instance sSession of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				(proc0_2)
				(proc0_13 1000 reverseBiaz)
				(= seconds 2)
			)
			(1
				(switch local0
					(0
						(proc0_18 Reverse_Biaz 660 9 108 139 self)
					)
					(1
						(if local9
							(= local9 0)
							(proc0_18 Reverse_Biaz 660 10 108 139 self)
						else
							(-- local0)
							(= local9 0)
							(proc0_18 Reverse_Biaz 660 11 108 139 self)
						)
					)
					(else 
						(if (< local9 10)
							(-- local0)
							(= local9 0)
							(proc0_18 Reverse_Biaz 660 12 108 139 self)
						else
							(proc0_18 Reverse_Biaz 660 13 108 139 self)
						)
					)
				)
			)
			(2
				(if (and (== local1 1) (not (HaveMouse)))
					(proc0_14 660 14 67 -1 15 70 280 80 {Tip od Ala})
				)
				(if (> local1 1)
					(rewind play: self)
					(reelOne cycleSpeed: 5 setCycle: Rev)
					(reelTwo cycleSpeed: 5 setCycle: Fwd)
					(reelThree cycleSpeed: 5 setCycle: Rev)
					(reelFour cycleSpeed: 5 setCycle: Fwd)
				else
					(self cue:)
				)
			)
			(3
				(if (> local1 1)
					(musicStop play: self)
					(reelOne cycleSpeed: 10)
					(reelTwo cycleSpeed: 10)
					(reelThree cycleSpeed: 10)
					(reelFour cycleSpeed: 10)
				else
					(self cue:)
				)
			)
			(4
				(if (> local1 1)
					(reelOne setCycle: 0)
					(reelTwo setCycle: 0)
					(reelThree setCycle: 0)
					(reelFour setCycle: 0)
					(= seconds 2)
				else
					(self cue:)
				)
			)
			(5
				(Format @temp0 660 15 local1)
				(proc0_18 Reverse_Biaz @temp0 108 139 self)
			)
			(6
				(reverseBiaz setLoop: 2 setCel: 0 setCycle: End self)
			)
			(7
				(reverseBiaz setCycle: Beg self)
			)
			(8
				(reverseBiaz setLoop: 0 setCycle: End self)
			)
			(9
				(reverseBiaz setCycle: Beg self)
			)
			(10
				(reverseBiaz setLoop: 1 setCel: 0 setCycle: End self)
			)
			(11
				(reverseBiaz setCycle: Beg self)
			)
			(12
				(reverseBiaz setLoop: 0 setCel: 0)
				(= cycles 1)
			)
			(13
				(reelOne cycleSpeed: 17 setCycle: Fwd)
				(reelTwo cycleSpeed: 15 setCycle: Rev)
				(reelThree cycleSpeed: 17 setCycle: Fwd)
				(reelFour cycleSpeed: 15 setCycle: Rev)
				(vuMeter view: 670 setLoop: 1 setCel: 0 setCycle: Fwd)
				(if (<= local0 1)
					(gLl5MDHandler addToFront: keyboard)
					(gLl5KDHandler addToFront: keyboard)
					(DoSound sndSTOP 1)
					(gLongSong
						number: 660
						flags: 1
						setLoop: 1
						play:
						send: 9 78 1
					)
					(DoSound sndSTOP 0)
				else
					(DoSound sndSTOP 1)
					(gLongSong
						number: 660
						flags: 1
						setLoop: 1
						play: sAutoKeys
						send: 8 78 1
						send: 9 78 0
					)
					(DoSound sndSTOP 0)
				)
				(reverseBiaz setScript: sMonitorRecording)
				(proc0_3)
				(User canControl: 0)
				(gIconBar disable: 0 3 4 6 7)
				(if (> local0 1)
					(global2 setScript: sAutoKeys)
					(self dispose:)
				)
				(self cue:)
			)
			(14 (proc0_17 50 2 self))
			(15
				(proc0_2)
				(if local7 (local7 release:))
				(= local7 0)
				(= local8 0)
				(gLl5MDHandler delete: keyboard)
				(gLl5KDHandler delete: keyboard)
				(= seconds 3)
			)
			(16
				(proc0_3)
				(gIconBar disable: 0)
				(sMonitorRecording dispose:)
			)
			(17 (self dispose:))
		)
	)
)

(instance sMonitorRecording of Script
	(properties)
	
	(method (dispose)
		(reelOne setCycle: 0)
		(reelTwo setCycle: 0)
		(reelThree setCycle: 0)
		(reelFour setCycle: 0)
		(vuMeter setCycle: 0 setLoop: 0)
		(gLongSong stop:)
		(reverseBiaz setLoop: 0 setCycle: Beg self)
		(if (> local0 1)
			(global2 setScript: sEndSession)
		else
			(++ local0)
			(++ local1)
			(gLarry setScript: sSession)
		)
		(super dispose:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 3 6)))
			(1
				(if (Random 0 1)
					(reverseBiaz setLoop: 0 setCel: 0 setCycle: End self)
				else
					(reverseBiaz setLoop: 1 setCel: 0 setCycle: End self)
				)
			)
			(2
				(reverseBiaz setCycle: Beg self)
			)
			(3 (self changeState: 0))
		)
	)
)

(instance sAutoKeys of Script
	(properties)
	
	(method (changeState newState &tmp temp0 gLongSongPrevSignal)
		(switch (= state newState)
			(0
				(User canInput: 0)
				(gIconBar disable: 0 1 3 4 6 7)
				(gIconBar curIcon: (gIconBar at: 2))
			)
			(1
				(if
				(== (= gLongSongPrevSignal (gLongSong prevSignal?)) -1)
					(register release:)
					(= cycles 1)
				else
					(= temp0 (- 30 (- gLongSongPrevSignal 60)))
					(if register (register release:))
					(= register (keyboard at: temp0))
					(gGame
						setCursor:
							gCursorNumber
							1
							(if (register white?)
								(+ (register x?) 5)
							else
								(register x?)
							)
							(if (register white?)
								(- (register y?) 10)
							else
								(- (register y?) 12)
							)
					)
					(register depress: 0)
					(self changeState: 0)
				)
			)
			(2
				(sMonitorRecording dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sEndSession of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_13 0) (= seconds 3))
			(1
				(= local2 1)
				(if local3
					(proc0_18 Reverse_Biaz 660 16 108 139 self)
				else
					(proc0_10 8 126)
					(proc0_18 Reverse_Biaz 660 17 108 139 self)
				)
			)
			(2
				(global2 setScript: sReturnFromSynth)
				(self dispose:)
			)
		)
	)
)

(instance sEnterBooth of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(User canControl: 0)
				(User canInput: 0)
				(gLarry setPri: 4 setMotion: PolyPath 229 101 self)
			)
			(1
				(gLongSong number: 40 setVol: 127 setLoop: 1 play:)
				(door ignoreActors: 1 setPri: 3 setCycle: End self)
			)
			(2
				(gLarry setMotion: MoveTo 279 74 self)
			)
			(3
				(door dispose:)
				(global2 drawPic: 670)
				(reverseBiaz show:)
				(gLarry view: 681 setLoop: 1 setCel: 0 x: 241 y: 71 show:)
				(reelOne show:)
				(reelTwo show:)
				(reelThree show:)
				(reelFour show:)
				(vuMeter show:)
				(keyboard init:)
				(music init:)
				(synthPanel init:)
				(panelExtender show:)
				(gIconBar disable: 0)
				(= seconds 3)
			)
			(4
				(proc0_18 Reverse_Biaz 660 18 108 139 self)
			)
			(5
				(reverseBiaz setCycle: End self)
			)
			(6
				(reverseBiaz setCycle: Beg self)
			)
			(7
				(reverseBiaz setLoop: 1 setCel: 0 setCycle: End self)
			)
			(8
				(reverseBiaz setCycle: Beg self)
			)
			(9
				(reverseBiaz setLoop: 0)
				(= cycles 1)
			)
			(10
				(reverseBiaz view: 681 setLoop: 0 setCel: 0 x: 203 y: 71)
				(= cycles 1)
			)
			(11
				(reelOne setCycle: Fwd)
				(reelTwo setCycle: Rev)
				(self cue:)
			)
			(12
				(DoSound sndSTOP 1)
				(gLongSong
					number: 660
					flags: 1
					setLoop: 1
					play: sStopMusic
					send: 8 78 1
				)
				(DoSound sndSTOP 0)
				(reverseBiaz setScript: sStopMusic)
				(self cue:)
			)
			(13 (= seconds 10))
			(14
				(gLongSong fade: 80 15 12 0)
				(proc0_18 Reverse_Biaz 660 19 108)
				(proc0_3)
				(User canControl: 0)
				(User canInput: 1)
				(gIconBar disable: 0)
				(proc0_17 300 0 self)
			)
			(15
				(proc0_2)
				(proc0_18 Reverse_Biaz 660 20 108)
				(keyboard dispose:)
				(global2 drawPic: 1 6)
				(= ticks 120)
			)
			(16
				(proc0_14 660 21)
				(= ticks 120)
			)
			(17
				(global2 newRoom: 200 7)
				(self dispose:)
			)
		)
	)
)

(instance sStopMusic of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(if (== (gLongSong prevSignal?) -1)
					(reelOne setCycle: 0)
					(reelTwo setCycle: 0)
					(= cycles 1)
				else
					(self changeState: 0)
				)
			)
			(2 (self dispose:))
		)
	)
)

(instance sDrunkReverse of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLl5Timer dispose: delete:)
				(sEnterBooth dispose:)
				(= ticks 123)
			)
			(1
				(proc0_18 gLarry 660 22)
				(= ticks 60)
			)
			(2
				(proc0_18 Reverse_Biaz 660 23 108 139 self)
			)
			(3 (= ticks 60))
			(4
				(proc0_18 Reverse_Biaz 660 24 108 139 self)
			)
			(5 (= ticks 60))
			(6
				(gLarry hide:)
				(reverseBiaz
					view: 683
					setLoop: 0
					setCel: 0
					x: 231
					y: 71
					cycleSpeed: 13
					setCycle: CT 1 1 self
				)
			)
			(7 (= ticks 60))
			(8
				(reverseBiaz setCycle: CT 3 1 self)
			)
			(9 (= ticks 60))
			(10
				(reverseBiaz setCycle: End self)
			)
			(11
				(glassesClink play:)
				(= ticks 123)
			)
			(12
				(reverseBiaz setLoop: 1 setCel: 0 setCycle: End self)
			)
			(13 (= ticks 123))
			(14
				(proc0_18 Reverse_Biaz 660 25 108 139 self)
			)
			(15 (= ticks 60))
			(16
				(proc0_18 gLarry 660 26)
				(= ticks 123)
			)
			(17
				(proc0_18 gLarry 660 27)
				(reverseBiaz setLoop: 0 setCel: 2 setCycle: CT 3 1 self)
			)
			(18 (= ticks 60))
			(19
				(reverseBiaz setLoop: 1 setCel: 0 setCycle: End self)
			)
			(20 (= ticks 60))
			(21
				(switch local5
					(0 (proc0_18 gLarry 660 28))
					(1 (proc0_18 gLarry 660 29))
					(2 (proc0_18 gLarry 660 30))
					(3 (proc0_18 gLarry 660 31))
				)
				(= ticks 90)
			)
			(22
				(reverseBiaz setLoop: 0 setCel: 2 setCycle: CT 3 1 self)
			)
			(23 (= ticks 60))
			(24
				(reverseBiaz setLoop: 1 setCel: 0 setCycle: End self)
			)
			(25 (= ticks 60))
			(26
				(switch local5
					(0
						(proc0_18 Reverse_Biaz 660 32 108 139 self)
					)
					(1
						(proc0_18 Reverse_Biaz 660 33 108 139 self)
					)
					(2
						(proc0_18 Reverse_Biaz 660 34 108 139 self)
					)
					(3
						(proc0_18 Reverse_Biaz 660 35 108 139 self)
					)
				)
			)
			(27
				(= ticks 90)
				(if (< (++ local5) 4) (= state (- state 7)))
			)
			(28
				(gLarry show:)
				(zing play:)
				(reverseBiaz
					view: 683
					setLoop: 2
					setCel: 0
					x: 241
					y: 71
					setCycle: End self
				)
			)
			(29 (= seconds 3))
			(30
				(giveTape init:)
				(proc0_10 40 130)
				(gLarry get: 6)
				(= seconds 3)
			)
			(31
				(proc0_10 18 127)
				(proc0_18 Reverse_Biaz 660 36 108 139 self)
			)
			(32 (= seconds 3))
			(33
				(proc0_14 660 37)
				(= cycles 3)
			)
			(34
				(proc0_7 20)
				(global2 newRoom: 690)
			)
		)
	)
)

(instance sTalkScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(switch local4
					(0 (proc0_18 gLarry 660 38))
					(1 (proc0_18 gLarry 660 39))
					(2 (proc0_18 gLarry 660 40))
					(3 (proc0_18 gLarry 660 41))
					(4 (proc0_18 gLarry 660 42))
					(5 (proc0_18 gLarry 660 43))
					(6
						(gLl5Timer dispose: delete:)
						(sEnterBooth dispose:)
						(proc0_18 gLarry 660 44)
					)
				)
				(= ticks 60)
			)
			(1
				(switch local4
					(0
						(proc0_18 Reverse_Biaz 660 45 108 139 self)
					)
					(1
						(proc0_18 Reverse_Biaz 660 46 108 139 self)
					)
					(2
						(proc0_18 Reverse_Biaz 660 47 108 139 self)
					)
					(3
						(proc0_18 Reverse_Biaz 660 48 108 139 self)
					)
					(4 (= cycles 2))
					(5
						(proc0_18 Reverse_Biaz 660 49 108 139 self)
					)
					(6
						(proc0_18 Reverse_Biaz 660 50 108 139 self)
					)
				)
			)
			(2
				(++ local4)
				(proc0_16)
				(if (> local4 6)
					(self setScript: sDoSex)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance sDoSex of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(proc0_14 660 51)
				(gLongSong fade: 0 15 12 1)
				(= ticks 60)
			)
			(1
				(gLongSong2 number: 663 setLoop: -1 flags: 1 play:)
				(gLarry hide:)
				(reverseBiaz
					view: 682
					setLoop: 0
					setCel: 0
					x: 222
					y: 71
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(2 (= ticks 180))
			(3
				(reverseBiaz setLoop: 1 setCel: 0 setCycle: End self)
			)
			(4 (= ticks 240))
			(5
				(reverseBiaz
					setLoop: 2
					setCel: 0
					x: 235
					y: 71
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(6 (= ticks 120))
			(7
				(reverseBiaz
					setLoop: 3
					setCel: 0
					x: 263
					y: 71
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(8 (= ticks 120))
			(9
				(reverseBiaz
					setLoop: 2
					setCel: 0
					x: 235
					y: 71
					cycleSpeed: 10
					setCycle: CT 5 1 self
				)
			)
			(10
				(reelThree setCycle: Fwd)
				(reelFour setCycle: Rev)
				(vuMeter view: 670 setLoop: 1 setCel: 0 setCycle: Fwd)
				(= ticks 180)
			)
			(11
				(reverseBiaz
					setLoop: 2
					x: 235
					y: 71
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(12 (= ticks 120))
			(13
				(reverseBiaz
					setLoop: 4
					setCel: 0
					x: 255
					y: 73
					setCycle: End self
				)
			)
			(14
				(reverseBiaz
					setLoop: 5
					setCel: 0
					x: 213
					y: 72
					setCycle: End self
				)
			)
			(15 (= ticks 120))
			(16
				(reverseBiaz
					setLoop: 2
					setCel: 0
					x: 235
					y: 71
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(17 (= ticks 120))
			(18
				(reverseBiaz
					setLoop: 6
					setCel: 0
					x: 230
					y: 72
					setCycle: End self
				)
			)
			(19
				(reverseBiaz
					setLoop: 5
					setCel: 0
					x: 213
					y: 72
					setCycle: End self
				)
			)
			(20 (= ticks 240))
			(21
				(reverseBiaz
					setLoop: 7
					setCel: 0
					x: 213
					y: 73
					setCycle: End self
				)
			)
			(22 (= ticks 180))
			(23
				(if local6 (proc0_10 10 128) else (proc0_10 16 129))
				(keyboard dispose:)
				(global2 drawPic: 1 6)
				(= ticks 120)
			)
			(24
				(proc0_14 660 52)
				(proc0_10 40 130)
				(gLarry get: 6)
				(self cue:)
			)
			(25 (= ticks 120))
			(26
				(proc0_14 660 53)
				(proc0_14 660 54)
				(proc0_14 660 55)
				(global2 newRoom: 690)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 249
		y 96
		description {dveøe}
		lookStr {Tyto dveøe vedou do øídicí kabiny a k Reversi Biazovi.}
		view 660
		signal $4001
		cycleSpeed 10
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 660 56))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance reverseBiaz of Prop
	(properties
		x 286
		y 64
		description {Reverse Biaz}
		lookStr {Reverse Biaz je muž, kterého F.B.I. spojuje s pozpátku nahrávanými podprahovými zprávami nahrávanými v tomto studiu. Ale vypadá roztomile.}
		view 662
		priority 5
		signal $4011
		cycleSpeed 10
	)
	
	(method (doit)
		(if (and cycler (not (IsObject cycler))) (= cycler 0))
		(super doit:)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(if local2
					(proc0_18 Reverse_Biaz 660 57 108)
				else
					(proc0_14 660 58)
				)
			)
			(5
				(if local2
					(global2 setScript: sTalkScript)
				else
					(proc0_18 Reverse_Biaz 660 59 108)
				)
			)
			(4
				(switch param2
					(4
						(if local2
							(gLarry put: 4)
							(global2 setScript: sDrunkReverse)
						else
							(proc0_14 660 60)
						)
					)
					(else 
						(proc0_18 Reverse_Biaz 660 61 108)
					)
				)
			)
			(10
				(if local2
					(= local6 1)
					(global2 setScript: sDoSex)
				else
					(proc0_14 660 62)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
	
	(method (cue)
		(= local0 2)
		(= local3 1)
		(sSession dispose:)
		(sMonitorRecording dispose:)
	)
)

(instance giveTape of View
	(properties
		x 241
		y 73
		view 683
		loop 3
		priority 4
		signal $0010
	)
)

(instance panelExtender of View
	(properties
		x 183
		y 83
		description {mixážní pult v øídicí místnosti}
		sightAngle 40
		view 670
		loop 6
		priority 3
		signal $0011
	)
	
	(method (doVerb theVerb param2)
		(controlPanel doVerb: theVerb param2)
	)
)

(instance reelOne of Prop
	(properties
		x 214
		y 26
		description {páskový kotouè}
		sightAngle 40
		view 670
		loop 2
		signal $0001
		cycleSpeed 15
		detailLevel 2
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 660 63))
			(3
				(if local2 (proc0_14 660 64) else (proc0_14 660 65))
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance reelTwo of Prop
	(properties
		x 236
		y 26
		description {páskový kotouè}
		sightAngle 40
		view 670
		loop 3
		signal $0001
		cycleSpeed 20
		detailLevel 2
	)
	
	(method (doVerb theVerb param2)
		(reelOne doVerb: theVerb param2)
	)
)

(instance reelThree of Prop
	(properties
		x 261
		y 27
		description {páskový kotouè}
		sightAngle 40
		view 670
		loop 4
		signal $0001
		cycleSpeed 15
		detailLevel 3
	)
	
	(method (doVerb theVerb param2)
		(reelOne doVerb: theVerb param2)
	)
)

(instance reelFour of Prop
	(properties
		x 283
		y 27
		description {páskový kotouè}
		sightAngle 40
		view 670
		loop 5
		signal $0001
		cycleSpeed 20
		detailLevel 3
	)
	
	(method (doVerb theVerb param2)
		(reelOne doVerb: theVerb param2)
	)
)

(instance vuMeter of Prop
	(properties
		x 169
		y 29
		description {VU metr}
		sightAngle 40
		lookStr {Tento mìøiè mìøí dynamické úrovnì zvuku v decibelech, z nichž každý je pøibližnì 1 decibel.}
		view 670
		signal $0001
		cycleSpeed 10
		detailLevel 4
	)
)

(class synthKey of Prop
	(properties
		x 0
		y 0
		z 0
		heading 0
		noun 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		description {klávesa}
		sightAngle 26505
		actions 0
		onMeCheck $6789
		approachX 0
		approachY 0
		approachDist 0
		_approachVerbs 26505
		lookStr 0
		yStep 2
		view 673
		loop 0
		cel 0
		priority 0
		underBits 0
		signal $0000
		lsTop 0
		lsLeft 0
		lsBottom 0
		lsRight 0
		brTop 0
		brLeft 0
		brBottom 0
		brRight 0
		palette 0
		cycleSpeed 6
		script 0
		cycler 0
		timer 0
		detailLevel 1
		frequency 0
		white 0
	)
	
	(method (doit &tmp userCurEvent temp1)
		(super doit:)
		(= userCurEvent (User curEvent?))
		(if
			(and
				(== local7 self)
				(!= self (= temp1 (localproc_2a2d userCurEvent)))
			)
			(self release:)
			(= local7 temp1)
			(if temp1 (temp1 depress:))
		)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(proc0_14 660 66)
				(proc0_14 660 67)
			)
			(3
				(if local2
					(proc0_14 660 68)
				else
					(super doVerb: theVerb param2 &rest)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
	
	(method (cue)
		(self release:)
	)
	
	(method (depress param1)
		(if local8 (local8 release:) (= local8 0))
		(self setCel: 1)
		(if param1
			(++ local9)
			(gLongSong send: 8 144 frequency 100)
		)
	)
	
	(method (release)
		(self setCel: 0)
		(gLongSong send: 8 128 frequency 0)
	)
)

(instance keyboard of EventHandler
	(properties)
	
	(method (init &tmp temp0 temp1 newSynthKey temp3 temp4 temp5 temp6 temp7 temp8 temp9)
		(super init: &rest)
		(= temp4 0)
		(while (< temp4 31)
			(= temp1 (/ (= temp0 temp4) 12))
			(= temp3 (mod (= temp0 (- temp0 (* temp1 12))) 2))
			(if (< temp0 5) (-- temp3))
			(= temp7 ((= newSynthKey (synthKey new:)) view?))
			(= temp8
				(if temp3
					(switch temp0
						(0 1)
						(2 2)
						(4 3)
						(5 1)
						(7 2)
						(9 2)
						(11 3)
					)
				else
					0
				)
			)
			(if temp3
				(if (> temp0 4) (++ temp0))
				(= temp5
					(+ (= temp5 (* (/ temp0 2) 18)) (* temp1 126))
				)
				(= temp6 189)
			else
				(= temp5
					(+ (= temp5 (* (/ temp0 2) 18)) 18 (* temp1 126))
				)
				(= temp6 180)
			)
			(= temp9 (+ temp4 60))
			(newSynthKey
				setLoop: temp8
				x: temp5
				y: temp6
				frequency: temp9
				white: temp3
				ignoreActors:
				setPri: (if temp3 -1 else 15)
				stopUpd: 1
				init:
			)
			(self addToFront: newSynthKey)
			(++ temp4)
		)
	)
	
	(method (dispose)
		(gLl5MDHandler delete: self)
		(gLl5KDHandler delete: self)
		(super dispose:)
	)
	
	(method (handleEvent pEvent &tmp temp0 temp1)
		(cond 
			(local7
				(if (== (pEvent type?) evMOUSERELEASE)
					(local7 release:)
					(= local7 0)
				)
				(pEvent claimed: 1)
			)
			((== (pEvent type?) evMOUSEBUTTON)
				(if
					(and
						(= temp1 (localproc_2a2d pEvent))
						(!= ((gIconBar curIcon?) cursor?) 1)
					)
					(temp1 depress: 1)
					(= local7 temp1)
					(pEvent claimed: 1)
				else
					(super handleEvent: pEvent &rest)
				)
			)
			((== (pEvent type?) evKEYBOARD)
				(if
					(!=
						(= temp1 (localproc_2850 pEvent))
						(keyboard at: -1)
					)
					(temp1 depress: 1)
					(= local8 temp1)
					((Timer new:) setCycle: temp1 5)
				else
					(super handleEvent: pEvent &rest)
				)
				(pEvent claimed: 1)
			)
		)
	)
)

(instance synth of Feature
	(properties
		x 87
		y 102
		nsTop 88
		nsLeft 77
		nsBottom 115
		nsRight 100
		description {tvùj syntezátor}
		sightAngle 40
		approachX 67
		approachY 131
		lookStr {Toto je syntezátor, a Reverse Biaz po tobì chce, abys na nìj zahrála.}
	)
	
	(method (doVerb theVerb param2)
		(if (== theVerb 3)
			(gLarry setScript: sUsesSynth)
		else
			(super doVerb: theVerb param2 &rest)
		)
	)
)

(instance musicStands of Feature
	(properties
		x 55
		y 167
		nsTop 147
		nsLeft 31
		nsBottom 187
		nsRight 80
		description {stojany na noty}
		sightAngle 40
		lookStr {Vidíš hromadu notových stojanù. Nebo je to shluk notových stojanù? Nebo je to spíš chumel stojanù na noty? Vždycky na to zapomeneš.}
	)
)

(instance recordingBooth of Feature
	(properties
		x 280
		y 52
		nsTop 22
		nsLeft 256
		nsBottom 83
		nsRight 304
		description {øídicí místnost}
		sightAngle 40
		lookStr {Ze své øídicí místnosti vidí Reverse celé studio. Pøes zvukotìsné sklo s tebou mùže mluvit pøes talkback reproduktor.}
	)
)

(instance overhangingMike of Feature
	(properties
		x 100
		y 63
		nsTop 56
		nsLeft 94
		nsBottom 70
		nsRight 107
		description {mikrofon nad hlavou}
		sightAngle 40
		lookStr {Pøemýšlíš, kolik nekalých nahrávek bylo poøízeno tímto mikrofonem.}
	)
)

(instance drums of Feature
	(properties
		x 178
		y 73
		nsTop 51
		nsLeft 135
		nsBottom 96
		nsRight 222
		description {bicí souprava}
		sightAngle 40
		lookStr {Stejnì jako ve vìtšinì studií je bicí souprava za sklem, aby se zlepšilo oddìlení jejího zvuku od zvuku ostatních hudebníkù.}
	)
)

(instance music of Feature
	(properties
		x 96
		y 59
		nsTop 17
		nsLeft 48
		nsBottom 102
		nsRight 144
		description {hudba}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(if local2 (proc0_14 660 69) else (proc0_14 660 70))
			)
			(3
				(if local2 (proc0_14 660 71) else (proc0_14 660 72))
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance synthPanel of Feature
	(properties
		x 159
		y 130
		nsTop 111
		nsBottom 149
		nsRight 319
		description {ovládací panel syntezátoru}
		sightAngle 40
		lookStr {Pro tuto nahrávací relaci des Rever Records na programování tohoto syntezátoru rozhodnì nešetøili.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(if local2 (proc0_14 660 73) else (proc0_14 660 74))
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance controlPanel of Feature
	(properties
		x 238
		y 76
		nsTop 73
		nsLeft 194
		nsBottom 80
		nsRight 283
		description {mixážní pult v øídicí místnosti}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 660 75))
			(3 (proc0_14 660 76))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance controlPanel2 of Feature
	(properties
		x 232
		y 58
		nsTop 50
		nsLeft 168
		nsBottom 67
		nsRight 296
		description {studiový ovládací panel}
		sightAngle 40
		lookStr {Tento panel obsahuje mnoho digitálních reverbù a speciálních efektù, výkonové zesilovaèe, propojovací pole a výtisk Playboye z minulého mìsíce.}
	)
)

(instance rewind of Sound
	(properties
		number 661
	)
)

(instance musicStop of Sound
	(properties
		number 662
	)
)

(instance glassesClink of Sound
	(properties
		number 664
		priority 15
	)
)

(instance zing of Sound
	(properties
		number 665
	)
)

(instance Reverse_Biaz of Talker
	(properties
		nsTop 15
		nsLeft 30
		view 1672
		loop 3
		viewInPrint 1
		name "Reverse Biaz"
	)
	
	(method (init)
		(= bust reverseBust)
		(= eyes reverseEyes)
		(= mouth reverseMouth)
		(super init: &rest)
	)
)

(instance reverseBust of Prop
	(properties
		view 1672
		loop 1
	)
)

(instance reverseEyes of Prop
	(properties
		nsTop 31
		nsLeft 22
		view 1672
		loop 2
		cycleSpeed 70
	)
)

(instance reverseMouth of Prop
	(properties
		nsTop 36
		nsLeft 15
		view 1672
		cycleSpeed 5
	)
)
