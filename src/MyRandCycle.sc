;;; Sierra Script 1.0 - (do not remove this comment)
(script# 640)
(include sci.sh)
(use Main)
(use LLRoom)
(use Door)
(use RTRandCycle)
(use Osc)
(use Polygon)
(use CueObj)
(use n958)
(use Rev)
(use Sound)
(use Cycle)
(use User)
(use PicView)
(use Obj)

(public
	rm640 0
)

(local
	local0
	local1
	local2
	local3
	local4 =  1
	local5
	turnTableWRecordCycleSpeed =  18
	local7
)
(procedure (localproc_2b30)
	(= local1 1)
	(proc0_14 640 48)
	(proc0_18 Reverse_Biaz 640 49 108)
)

(instance rm640 of LLRoom
	(properties
		picture 640
		north 660
	)
	
	(method (init)
		(gLarry init: normalize: 570)
		(proc0_3)
		(switch gGNumber
			(north
				(gLarry posn: 189 86 setHeading: 180 edgeHit: 0)
				(= local1 1)
				(if
				(and (not (proc0_6 22)) (not (gLarry has: 5)))
					(record init: approachVerbs: 2 3)
				)
				(if (proc0_6 22) (record2 init: approachVerbs: 2 3))
				(gLongSong number: 620 setVol: 127 flags: 1 play:)
			)
			(else 
				(gLarry
					posn: 59 139
					setHeading: 90
					edgeHit: 0
					setPri: 9
					setScript: sExitElevator
				)
				(record init: approachVerbs: 2 3)
			)
		)
		(proc958_0 129 650)
		(proc958_0 128 650 641 1672)
		(proc958_0
			132
			640
			641
			642
			643
			644
			645
			646
			201
			648
			621
			622
		)
		(super init:)
		(stereo init: approachVerbs: 2 3 4)
		(elevator init: approachVerbs: 3)
		(door init: approachVerbs: 3)
		(reverseBiaz init: setScript: sMonitorRecording)
		(statue init:)
		(speakerA init:)
		(speakerB init:)
		(plant init:)
		(shelves init:)
		(recordJacketsA init:)
		(recordJacketsB init:)
		(fGoldRecords init:)
		(plaque init: approachVerbs: 2 3 4)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						0
						117
						99
						117
						105
						126
						62
						149
						77
						149
						125
						118
						145
						112
						186
						102
						229
						111
						232
						128
						206
						141
						154
						141
						130
						139
						85
						162
						51
						159
						62
						164
						54
						175
						28
						175
						16
						170
						0
						175
					yourself:
				)
				((Polygon new:)
					type: 2
					init:
						67
						165
						105
						171
						116
						160
						212
						160
						224
						134
						255
						129
						252
						115
						193
						100
						0
						100
						0
						93
						220
						93
						287
						107
						286
						139
						236
						148
						241
						175
						231
						181
						198
						185
						142
						185
						111
						183
						90
						184
						66
						183
						61
						174
					yourself:
				)
				((Polygon new:)
					type: 2
					init:
						103
						83
						208
						83
						201
						78
						201
						52
						178
						52
						178
						79
						0
						79
						0
						0
						319
						0
						319
						189
						245
						189
						245
						166
						290
						160
						301
						171
						317
						161
						289
						130
						315
						130
						315
						108
						279
						78
						227
						78
						228
						83
						256
						83
						262
						86
						253
						92
						226
						92
						215
						90
						100
						90
					yourself:
				)
		)
	)
	
	(method (doit)
		(if (and (proc0_5 gLarry 2) (not local1))
			(localproc_2b30)
		)
		(if (and (proc0_5 gLarry 4) (not local1))
			(localproc_2b30)
		)
		(super doit: &rest)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1
				(if (== curPic 650)
					(global2 setScript: sReturnsFromStereo)
					1
				)
			)
			(2
				(if (== curPic 650)
					(super doVerb: theVerb param2 &rest)
				else
					(proc0_14 640 0)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(cond 
			((not (== newRoomNumber 620)) (gLongSong fade: 0 15 12 1) (gLongSong2 fade: 0 15 12 1))
			(local3
				(gLongSong setVol: 127 play:)
				(gLongSong2 fade: 0 15 12 1)
			)
		)
	)
)

(instance sExitElevator of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_2) (= seconds 2))
			(1
				(elevatorDing play:)
				(= cycles 15)
			)
			(2
				(elevatorDoor play:)
				(elevator setCycle: End self)
			)
			(3
				(elevatorDoor stop:)
				(elevator setPri: 9)
				(gLarry setPri: 9 setMotion: MoveTo 73 148)
				(= seconds 2)
			)
			(4
				(elevatorDoor play:)
				(elevator setCycle: Beg self)
			)
			(5
				(elevatorDoor stop:)
				(gLarry setPri: -1)
				(elevator stopUpd: 1)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance sGetRecord of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canInput: 0)
				(gLarry setHeading: 0 self)
			)
			(1
				(gLarry
					view: 641
					setLoop: 0
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(2
				(record dispose:)
				(gLarry get: 5 setCycle: Beg self)
			)
			(3
				(if local4
					(proc0_10 12 121)
					(= local4 0)
					(proc0_14 640 1)
					(proc0_14 640 2)
					(proc0_14 640 3 67 -1 185)
				)
				(gLarry normalize: 570 loop: 3)
				(User canInput: 1)
				(self dispose:)
			)
		)
	)
)

(instance sMonitorRecording of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 10))
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

(instance sSpeed78Reverse of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (needle cel?) (= seconds 10) else (self dispose:))
			)
			(1
				(proc0_2)
				(if (not (DoSound sndSET_SOUND))
					(proc0_14 640 4 67 -1 20 108 self)
				else
					(gLongSong2 setVol: 80)
					(message1 play: self)
				)
			)
			(2
				(gLongSong2 setVol: 127)
				(proc0_10 3 125)
				(proc0_14 640 5 67 -1 20 108 self)
			)
			(3
				(proc0_14 640 6 67 -1 185 108 self)
			)
			(4
				(proc0_3)
				(User canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance sSpeed33Reverse of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (needle cel?) (= seconds 10) else (self dispose:))
			)
			(1
				(proc0_2)
				(if (not (DoSound sndSET_SOUND))
					(proc0_14 640 7 67 -1 20 108 self)
				else
					(gLongSong2 setVol: 80)
					(message2 play: self)
				)
			)
			(2
				(gLongSong2 setVol: 127)
				(proc0_10 3 123)
				(proc0_14 640 8 67 -1 20 108 self)
			)
			(3
				(proc0_14 640 9 67 -1 20 108 self)
			)
			(4
				(proc0_14 640 10 67 -1 20 108 self)
			)
			(5
				(proc0_3)
				(User canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance sSpeed78Forward of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (needle cel?) (= seconds 10) else (self dispose:))
			)
			(1
				(proc0_2)
				(if (not (DoSound sndSET_SOUND))
					(proc0_14 640 11 67 -1 20 108 self)
				else
					(gLongSong2 setVol: 80)
					(message3 play: self)
				)
			)
			(2
				(gLongSong2 setVol: 127)
				(proc0_10 3 124)
				(proc0_14 640 12 67 -1 185 108 self)
			)
			(3
				(proc0_3)
				(User canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance sSpeed33Forward of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (needle cel?) (= seconds 10) else (self dispose:))
			)
			(1
				(proc0_2)
				(proc0_10 3 122)
				(proc0_14 640 13 67 -1 20 108 self)
			)
			(2
				(proc0_3)
				(User canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance sUsesStereo of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0)
				(User canInput: 1)
				(gCast eachElementDo: #hide)
				(statue dispose:)
				(speakerA dispose:)
				(speakerB dispose:)
				(plant dispose:)
				(shelves dispose:)
				(recordJacketsA dispose:)
				(recordJacketsB dispose:)
				(fGoldRecords dispose:)
				(plaque dispose:)
				(reverseButton init: stopUpd:)
				(stopButton init: stopUpd:)
				(forwardButton init: stopUpd:)
				(button33 init: stopUpd:)
				(button78 init: stopUpd:)
				(needle init:)
				(if (proc0_6 22)
					(turnTableWRecord
						init:
						setCycle:
							(cond 
								((== local5 0) 0)
								((== local5 1) Fwd)
								((== local5 2) Rev)
							)
						cycleSpeed: turnTableWRecordCycleSpeed
					)
					(record2 dispose:)
				else
					(turntable init:)
				)
				(speakerOne
					init:
					setCycle: (if local7 MyRandCycle else 0)
				)
				(speakerTwo
					init:
					setCycle: (if local7 MyRandCycle else 0)
				)
				(global2 drawPic: 650)
				(proc0_22 1)
				(gIconBar curIcon: (gIconBar at: 2))
				(gGame setCursor: ((gIconBar curIcon?) cursor?))
				(stereo dispose:)
				(gLongSong fade: 0 15 12 0 self)
			)
			(1
				(gLongSong pause: 1)
				(self dispose:)
			)
		)
	)
)

(instance sReturnsFromStereo of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_3)
				(if (global2 script?) ((global2 script?) dispose:))
				(if (not (needle cel?))
					(gLongSong setVol: 127 pause: 0)
				)
				(stopButton dispose:)
				(forwardButton dispose:)
				(reverseButton dispose:)
				(button33 dispose:)
				(button78 dispose:)
				(needle dispose:)
				(if (proc0_6 22)
					(if (turnTableWRecord cycler?)
						(cond 
							(((turnTableWRecord cycler?) isKindOf: Fwd) (= local5 1))
							(((turnTableWRecord cycler?) isKindOf: Rev) (= local5 2))
						)
						(= local3 1)
					else
						(= local5 0)
						(= local3 0)
					)
					(record2 init:)
					(= turnTableWRecordCycleSpeed
						(turnTableWRecord cycleSpeed?)
					)
					(turnTableWRecord dispose:)
				else
					(turntable dispose:)
				)
				(if (speakerOne cycler?)
					(= local7 1)
				else
					(= local7 0)
				)
				(speakerOne dispose:)
				(speakerTwo dispose:)
				(if (not (gLarry has: 5)) (record show:))
				(stereo init: approachVerbs: 2 3 4)
				(global2 drawPic: (global2 picture?))
				(elevator show:)
				(gLarry show:)
				(door show:)
				(reverseBiaz show:)
				(statue init:)
				(speakerA init:)
				(speakerB init:)
				(plant init:)
				(shelves init:)
				(recordJacketsA init:)
				(recordJacketsB init:)
				(fGoldRecords init:)
				(plaque init: approachVerbs: 2 3 4)
				(proc0_22 0)
				(User canControl: 1)
				(self dispose:)
			)
		)
	)
)

(instance sStopButtonPressed of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (needle cel?) (proc0_2))
				(stopButton startUpd:)
				(= cycles 1)
			)
			(1
				(recordSwitch play:)
				(stopButton setPri: 10 setCycle: Osc 1 self)
			)
			(2
				(cond 
					((not (turnTableWRecord cycler?)) (proc0_14 640 14 67 -1 185))
					((not (proc0_6 22)) (proc0_14 640 15 67 -1 185))
					((needle cel?) (needle doVerb: 3))
				)
				(= cycles 1)
			)
			(3
				(User canControl: 0)
				(= seconds 3)
			)
			(4
				(turnTableWRecord setCycle: 0)
				(stopButton setPri: -1 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance sForwardButtonPressed of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(forwardButton startUpd:)
				(= cycles 1)
			)
			(1
				(recordSwitch play:)
				(forwardButton setPri: 10 setCycle: Osc 1 self)
			)
			(2
				(cond 
					((turnTableWRecord cycler?)
						(if
						(not ((turnTableWRecord cycler?) isKindOf: Fwd))
							(turnTableWRecord setCycle: Fwd)
							(if (needle cel?) (= local2 0) (speakerOne cue:))
							(if (== (turnTableWRecord cycleSpeed?) 6)
								(global2 setScript: sSpeed78Forward)
							else
								(global2 setScript: sSpeed33Forward)
							)
						)
					)
					((proc0_6 22) (turnTableWRecord setCycle: Fwd))
					(else (proc0_14 640 16))
				)
				(forwardButton setPri: -1 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance sReverseButtonPressed of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(reverseButton startUpd:)
				(= cycles 1)
			)
			(1
				(recordSwitch play:)
				(reverseButton setPri: 10 setCycle: Osc 1 self)
			)
			(2
				(cond 
					((turnTableWRecord cycler?)
						(if
						(not ((turnTableWRecord cycler?) isKindOf: Rev))
							(turnTableWRecord setCycle: Rev)
							(if (needle cel?) (= local2 0) (speakerOne cue:))
							(cond 
								((== (turnTableWRecord cycleSpeed?) 18) (global2 setScript: sSpeed33Reverse))
								((== (turnTableWRecord cycleSpeed?) 6) (global2 setScript: sSpeed78Reverse))
							)
						)
					)
					((proc0_6 22) (turnTableWRecord setCycle: Rev))
					(else (proc0_14 640 16))
				)
				(reverseButton setPri: -1 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance sButton33Pressed of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(button33 startUpd:)
				(= cycles 1)
			)
			(1
				(recordSwitch play:)
				(button33 setPri: 10 setCycle: Osc 1 self)
			)
			(2
				(if (turnTableWRecord cycler?)
					(if (== (turnTableWRecord cycleSpeed?) 6)
						(turnTableWRecord cycleSpeed: 18)
						(if (needle cel?) (= local2 0) (speakerOne cue:))
						(cond 
							(((turnTableWRecord cycler?) isKindOf: Rev) (global2 setScript: sSpeed33Reverse))
							(((turnTableWRecord cycler?) isKindOf: Fwd) (global2 setScript: sSpeed33Forward))
						)
					)
				else
					(turnTableWRecord cycleSpeed: 18)
					(proc0_14 640 17)
					(proc0_14 640 18 67 -1 185)
				)
				(button33 setPri: -1 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance sButton78Pressed of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(button78 startUpd:)
				(= cycles 1)
			)
			(1
				(recordSwitch play:)
				(button78 setPri: 10 setCycle: Osc 1 self)
			)
			(2
				(if (turnTableWRecord cycler?)
					(if (== (turnTableWRecord cycleSpeed?) 18)
						(turnTableWRecord cycleSpeed: 6)
						(if (needle cel?) (= local2 0) (speakerOne cue:))
						(if ((turnTableWRecord cycler?) isKindOf: Rev)
							(global2 setScript: sSpeed78Reverse)
						else
							(global2 setScript: sSpeed78Forward)
						)
					)
				else
					(turnTableWRecord cycleSpeed: 6)
					(proc0_14 640 19)
					(proc0_14 640 18 67 -1 185)
				)
				(button78 setPri: -1 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterElevator of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(elevatorDing play:)
				(= cycles 15)
			)
			(1
				(elevatorDoor play:)
				(elevator setCycle: End self)
			)
			(2
				(elevatorDoor stop:)
				(elevator setPri: 10)
				(gLarry setPri: 9 setMotion: MoveTo 59 139 self)
			)
			(3 (gLarry setHeading: 90 self))
			(4
				(proc0_18 Reverse_Biaz 640 20 108 139 self)
			)
			(5
				(elevatorDoor play:)
				(elevator setCycle: Beg self)
			)
			(6
				(elevatorDoor stop:)
				(global2 newRoom: 620)
				(self dispose:)
			)
		)
	)
)

(instance sPlayMusic of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local2
					(needleDownSpin play: self)
				else
					(= cycles 1)
				)
			)
			(1
				(proc0_3)
				(User canControl: 0)
				(cond 
					(((turnTableWRecord cycler?) isKindOf: Fwd)
						(if (== (turnTableWRecord cycleSpeed?) 6)
							(gLongSong2 number: 641 flags: 1 setLoop: -1 play:)
							(global2 setScript: sSpeed78Forward)
						else
							(gLongSong2 number: 640 flags: 1 setLoop: -1 play:)
							(global2 setScript: sSpeed33Forward)
						)
					)
					(((turnTableWRecord cycler?) isKindOf: Rev)
						(cond 
							((== (turnTableWRecord cycleSpeed?) 18)
								(gLongSong2 number: 642 flags: 1 setLoop: -1 play:)
								(global2 setScript: sSpeed33Reverse)
							)
							((== (turnTableWRecord cycleSpeed?) 6)
								(gLongSong2 number: 643 flags: 1 setLoop: -1 play:)
								(global2 setScript: sSpeed78Reverse)
							)
						)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance stereo of Feature
	(properties
		x 174
		y 163
		z 3
		nsTop 154
		nsLeft 151
		nsBottom 167
		nsRight 197
		description {pøehrávaè}
		sightAngle 40
		approachX 172
		approachY 185
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(global2 setScript: sUsesStereo)
			)
			(3
				(global2 setScript: sUsesStereo)
			)
			(4
				(if (== param2 5)
					(proc0_7 22)
					(gLarry put: 5)
					(global2 setScript: sUsesStereo)
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

(instance plaque of Feature
	(properties
		x 167
		y 161
		z 29
		nsTop 119
		nsLeft 153
		nsBottom 145
		nsRight 181
		description {plaketa}
		sightAngle 40
		approachX 159
		approachY 183
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(if (gCast contains: record)
					(proc0_14 640 21)
				else
					(proc0_14 640 22)
				)
			)
			(4
				(switch param2
					(5
						(record init:)
						(gLarry put: 5)
					)
					(else 
						(super doVerb: theVerb param2 &rest)
					)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance record of View
	(properties
		x 169
		y 162
		z 33
		description {zlatá deska}
		sightAngle 40
		approachX 159
		approachY 183
		view 640
		loop 2
		priority 14
		signal $4011
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(gLarry setScript: sGetRecord)
			)
			(2 (proc0_14 640 23))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance record2 of View
	(properties
		x 154
		y 164
		z 16
		description {pøehrávaè}
		sightAngle 40
		approachX 159
		approachY 183
		view 640
		loop 3
		priority 14
		signal $4011
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(global2 setScript: sUsesStereo)
			)
			(3
				(global2 setScript: sUsesStereo)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance elevator of Prop
	(properties
		x 50
		y 77
		description {výtah}
		approachX 65
		approachY 152
		lookStr {Tímto výtahem jsi pøijela.}
		view 640
		priority 10
		signal $4011
		cycleSpeed 12
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(cond 
					((proc0_6 21) (global2 setScript: sEnterElevator))
					(local1 (proc0_7 21) (proc0_18 Reverse_Biaz 640 24 108))
					(else (localproc_2b30))
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance reverseBiaz of Prop
	(properties
		x 251
		y 56
		description {Reverse Biaz}
		view 642
		cycleSpeed 12
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(proc0_14 640 25)
				(if (not local1) (localproc_2b30))
			)
			(5
				(proc0_14 640 26)
				(if (not local1) (localproc_2b30))
			)
			(3 (proc0_14 640 27))
			(4
				(switch param2
					(4 (proc0_14 640 28))
					(else  (proc0_14 640 29))
				)
			)
			(10 (proc0_14 640 30))
			(else  (proc0_14 640 31))
		)
	)
)

(instance turntable of Feature
	(properties
		x 174
		y 160
		nsTop 109
		nsLeft 112
		nsBottom 132
		nsRight 191
		description {gramofon}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 640 32))
			(3 (proc0_14 640 33))
			(4
				(switch param2
					(5
						(proc0_7 22)
						(gLarry put: 5)
						(turnTableWRecord init:)
						(gIconBar curIcon: (gIconBar at: 2))
						(gGame setCursor: ((gIconBar curIcon?) cursor?))
						(self dispose:)
					)
					(else 
						(super doVerb: theVerb param2 &rest)
					)
				)
			)
			(1
				(global2 setScript: sReturnsFromStereo)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance turnTableWRecord of Prop
	(properties
		x 150
		y 133
		description {zlatá deska}
		view 650
		loop 10
		cycleSpeed 18
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(if (self cycler?)
					(proc0_14 640 34)
				else
					(proc0_14 640 35)
				)
			)
			(3
				(if (self cycler?)
					(proc0_14 640 36)
				else
					(proc0_8 22)
					(gLarry get: 5)
					(turntable init:)
					(self dispose:)
				)
			)
			(1
				(global2 setScript: sReturnsFromStereo)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance needle of Prop
	(properties
		x 191
		y 111
		description {jehla}
		view 650
		loop 6
		priority 11
		signal $0011
		cycleSpeed 12
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(if (self cel?)
					(proc0_14 640 37)
				else
					(proc0_14 640 38)
				)
			)
			(3
				(cond 
					((self cel?)
						(= y (- y 1000))
						(= z 0)
						(proc0_2)
						(self setCycle: Beg speakerOne)
						(cond 
							((== (global2 script?) sStopButtonPressed) ((global2 script?) cue:))
							((global2 script?) ((global2 script?) dispose:))
						)
					)
					((proc0_6 22)
						(if
							(and
								(turnTableWRecord cycler?)
								(not (global2 script?))
							)
							(= y (+ y 1000))
							(= z 1000)
							(= local2 1)
							(proc0_2)
							(self setCycle: End speakerOne)
						else
							(proc0_14 640 39)
						)
					)
					(else (proc0_14 640 40))
				)
			)
			(1
				(global2 setScript: sReturnsFromStereo)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance speakerOne of Prop
	(properties
		x 243
		y 114
		description {reproduktory}
		view 650
		loop 8
		cycleSpeed 2
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 640 41))
			(1
				(global2 setScript: sReturnsFromStereo)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
	
	(method (cue)
		(needle stopUpd:)
		(if (needle cel?)
			(self setCycle: MyRandCycle)
			(speakerTwo setCycle: MyRandCycle)
			(self setScript: sPlayMusic)
		else
			(proc0_3)
			(User canControl: 0)
			(gLongSong2 stop:)
			(self setCycle: 0)
			(speakerTwo setCycle: 0)
		)
	)
)

(instance speakerTwo of Prop
	(properties
		x 75
		y 117
		description {reproduktory}
		view 650
		loop 9
		cycleSpeed 2
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 640 41))
			(1
				(global2 setScript: sReturnsFromStereo)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(class MyRandCycle of Cycle
	(properties
		client 0
		caller 0
		cycleDir 1
		cycleCnt 0
		completed 0
	)
	
	(method (doit)
		(++ cycleCnt)
		(if (> cycleCnt (client cycleSpeed?))
			(client setCel: (Random 0 1))
			(= cycleCnt 0)
		)
	)
)

(instance door of Door
	(properties
		x 177
		y 21
		description {dveøe studia}
		approachX 195
		approachY 83
		lookStr {Na dveøích je malá tabulka s nápisem: "Studio A".}
		view 640
		loop 1
		signal $0001
		entranceTo 660
		moveToX 195
		moveToY 73
		enterType 0
		exitType 0
	)
)

(instance reverseButton of Prop
	(properties
		x 105
		y 159
		description {tlaèítko Pozpátku}
		sightAngle 40
		view 650
		signal $0001
		cycleSpeed 12
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(global2 setScript: sReverseButtonPressed)
			)
			(2 (proc0_14 640 42))
			(1
				(global2 setScript: sReturnsFromStereo)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance stopButton of Prop
	(properties
		x 120
		y 160
		description {tlaèítko Stop}
		sightAngle 40
		view 650
		loop 1
		signal $0001
		cycleSpeed 12
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(global2 setScript: sStopButtonPressed)
			)
			(2 (proc0_14 640 43))
			(1
				(global2 setScript: sReturnsFromStereo)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance forwardButton of Prop
	(properties
		x 134
		y 161
		description {tlaèítko Vpøed}
		sightAngle 40
		view 650
		loop 2
		signal $0001
		cycleSpeed 12
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(global2 setScript: sForwardButtonPressed)
			)
			(2 (proc0_14 640 44))
			(1
				(global2 setScript: sReturnsFromStereo)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance button33 of Prop
	(properties
		x 188
		y 161
		description {tlaèítko 33}
		sightAngle 40
		view 650
		loop 3
		signal $0001
		cycleSpeed 12
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(global2 setScript: sButton33Pressed)
			)
			(2 (proc0_14 640 45))
			(1
				(global2 setScript: sReturnsFromStereo)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance button78 of Prop
	(properties
		x 217
		y 159
		description {tlaèítko 78}
		sightAngle 40
		view 650
		loop 5
		signal $0001
		cycleSpeed 12
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(global2 setScript: sButton78Pressed)
			)
			(2 (proc0_14 640 46))
			(1
				(global2 setScript: sReturnsFromStereo)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance statue of Feature
	(properties
		x 31
		y 141
		nsTop 114
		nsLeft 24
		nsBottom 169
		nsRight 43
		description {socha}
		sightAngle 40
		lookStr {Tato socha pøedstavuje patrona nahrávacích spoleèností - svatého Jehlu.}
	)
)

(instance speakerA of Feature
	(properties
		x 121
		y 200
		z 50
		nsTop 137
		nsLeft 112
		nsBottom 164
		nsRight 131
		description {levý reproduktor}
		sightAngle 40
		lookStr {Tento mìniè pøevádí elektrickou energii na rychle pulzující zvukové vlny.}
	)
)

(instance speakerB of Feature
	(properties
		x 215
		y 199
		z 50
		nsTop 137
		nsLeft 205
		nsBottom 161
		nsRight 225
		description {pravý reproduktor}
		sightAngle 40
		lookStr {Tento mìniè pøevádí elektrickou energii na rychle pulzující zvukové vlny.}
	)
)

(instance plant of Feature
	(properties
		x 233
		y 71
		nsTop 45
		nsLeft 220
		nsBottom 93
		nsRight 246
		description {rostlina}
		sightAngle 40
		lookStr {Pøi bližším zkoumání zjistíš, že se jedná o rostlinu.}
	)
)

(instance shelves of Feature
	(properties
		x 268
		y 110
		nsTop 83
		nsLeft 257
		nsBottom 137
		nsRight 279
		description {polièky}
		sightAngle 40
		lookStr {Polièky v kanceláøi jsou plné desek, kazet a knih.}
	)
)

(instance recordJacketsA of Feature
	(properties
		x 133
		y 15
		nsTop 10
		nsLeft 104
		nsBottom 20
		nsRight 162
		description {obaly na desky}
		sightAngle 40
		lookStr {Stìny kanceláøe des Rever Records zdobí mnoho obalù slavných alb.}
	)
)

(instance recordJacketsB of Feature
	(properties
		x 268
		y 15
		nsTop 11
		nsLeft 222
		nsBottom 20
		nsRight 315
		description {obaly desek}
		sightAngle 40
		lookStr {Stìny kanceláøe des Rever Records zdobí mnoho obalù slavných alb.}
	)
)

(instance elevatorDing of Sound
	(properties
		number 621
	)
)

(instance elevatorDoor of Sound
	(properties
		number 622
	)
)

(instance message1 of Sound
	(properties
		number 644
	)
)

(instance message2 of Sound
	(properties
		number 645
	)
)

(instance message3 of Sound
	(properties
		number 646
	)
)

(instance recordSwitch of Sound
	(properties
		number 201
	)
)

(instance needleDownSpin of Sound
	(properties
		number 648
	)
)

(instance Reverse_Biaz of Talker
	(properties
		nsTop 15
		nsLeft 35
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

(instance fGoldRecords of Feature
	(properties
		x 134
		y 77
		z 37
		nsTop 34
		nsLeft 108
		nsBottom 47
		nsRight 160
		description {zlaté desky}
		sightAngle 40
		lookStr {Tyto zlaté desky jsou pevnì pøipevnìny ke zdi.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 640 47))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)
