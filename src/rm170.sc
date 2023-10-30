;;; Sierra Script 1.0 - (do not remove this comment)
(script# 170)
(include sci.sh)
(use Main)
(use LLRoom)
(use Door)
(use n940)
(use Polygon)
(use CueObj)
(use Sound)
(use Cycle)
(use InvI)
(use PicView)
(use Obj)

(public
	rm170 0
)

(local
	local0
	local1
)
(instance rm170 of LLRoom
	(properties
		lookStr {Jsi na to tak pyön˝, na svou skromnou dÌlnu.}
		picture 170
		east 160
	)
	
	(method (init)
		(self setRegions: 40)
		(gLarry init: normalize: illegalBits: 8)
		(switch gGNumber
			(east 0)
			(else 
				(proc0_3)
				(gLarry posn: 160 160 edgeHit: 0)
			)
		)
		(super init:)
		(if
			(not
				(if (or (gLarry has: 2) (gLarry has: 3))
				else
					(gLarry has: 4)
				)
			)
			(camcorderTapes init: approachVerbs: 3)
		)
		(door init: approachVerbs: 3)
		(degausser init: approachVerbs: 4)
		(drawer1 init: approachVerbs: 3)
		(drawer2 init: approachVerbs: 3)
		(drawer3 init: approachVerbs: 3)
		(cabinet init:)
		(sterileBarrel init: approachVerbs: 3 4)
		(videoMonitor1 init:)
		(videoMonitor2 init:)
		(drain init:)
		(boxes init:)
		(videotapes1 init:)
		(videotapes2 init:)
		(videotapes3 init:)
		(videotapes4 init:)
		(videotapes5 init:)
		(videotapes6 init:)
		(videotapes7 init:)
		(lightWest init:)
		(lightEast init:)
		(dice init:)
		(eightTrack init: approachVerbs: 3)
		(global2
			addObstacle:
				((Polygon new:)
					type: 3
					init:
						319
						116
						216
						116
						204
						113
						204
						108
						209
						97
						198
						97
						190
						101
						36
						101
						11
						120
						114
						120
						109
						125
						60
						133
						14
						129
						3
						137
						3
						186
						156
						164
						239
						158
						242
						175
						235
						189
						315
						165
						315
						145
						284
						143
						255
						128
						283
						119
						319
						119
					yourself:
				)
		)
	)
)

(instance sOpenDrawer of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLongSong2 number: 171 setLoop: 1 play:)
				(gLarry
					view: 171
					setLoop: 0
					setCel: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(1 (= cycles 3))
			(2
				(switch register
					(3 (proc0_14 170 0 67 -1 150))
					(2 (proc0_14 170 1 67 -1 150))
					(1
						(if (proc0_6 85)
							(proc0_14 170 2 67 -1 150)
						else
							(proc0_14 170 3 67 -1 150)
							(proc0_10 8 85)
							(proc0_14 170 4 67 -1 150)
							(gLarry get: 1)
						)
					)
				)
				(= cycles 3)
			)
			(3
				(gLongSong2 number: 171 setLoop: 1 play:)
				(gLarry setCycle: Beg self)
			)
			(4
				(gLarry loop: 3 normalize: illegalBits: 8)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance sTapes of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry
					view: 171
					setLoop: 1
					setCel: 0
					posn: 237 158
					setCycle: CT 3 1 self
				)
				(egoBody init:)
			)
			(1
				(camcorderTapes dispose:)
				(gLarry setCycle: End self)
			)
			(2 (= cycles 5))
			(3
				(proc0_10 6 86)
				(gLarry get: 2 3 4)
				(= cycles 5)
			)
			(4
				(gLarry setLoop: 2 posn: 236 184)
				(proc0_14 170 5)
				(proc0_14 170 6 67 -1 185)
				(egoBody dispose:)
				(gLarry normalize: illegalBits: 8)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance sDegaussTape of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_2) (= cycles 1))
			(1
				(if (not register)
					(proc0_14 170 7)
					(self changeState: 3)
				else
					(gLongSong2 number: 172 setLoop: -1 play:)
					(proc0_10 2)
					(if (not local0)
						(proc0_14 170 8)
						(proc0_14 170 9 67 -1 185)
						(= local0 1)
						(= cycles 1)
					else
						(= ticks 120)
					)
				)
			)
			(2
				(gLongSong2 stop:)
				(proc0_9 1 register)
				(= cycles 1)
			)
			(3
				(gLarry
					setMotion: MoveTo (- (gLarry x?) 15) (+ (gLarry y?) 5) self
				)
			)
			(4
				(gLarry setLoop: 2 normalize: illegalBits: 8)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance camcorderTapes of View
	(properties
		x 249
		y 181
		description {z·znamy z videokamery}
		sightAngle 40
		approachX 236
		approachY 184
		lookStr {Naöel jsi je! Tohle jsou p·sky, kterÈ pot¯ebujeö do svÈ novÈ videokamery Pocket Protector.}
		view 170
		priority 15
		signal $4010
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (global2 setScript: sTapes))
			(4
				(switch param2
					(0 (proc0_14 170 10))
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

(instance egoBody of View
	(properties
		x 237
		y 185
		view 171
		loop 2
		priority 10
		signal $0010
	)
)

(instance door of Door
	(properties
		x 292
		y 116
		heading 135
		description {dve¯e do haly}
		approachX 240
		approachY 117
		lookStr {Dve¯e do haly ti p¯ipadajÌ tak zn·mÈ. NejspÌö proto, ûe jsi tudy vstoupil do tÈto mÌstnosti! Vzadu visÌ tv˘j kalend·¯ "Videotechnikova dÏvËata", otev¯en˝ na stranÏ Miss ¯Ìjen, kter· m· (podle tvÈho n·zoru) nejlepöÌ "kotouËe" z celÈ party!}
		view 171
		loop 3
		entranceTo 160
		moveToX 285
		moveToY 116
		enterType 0
		exitType 0
	)
	
	(method (init)
		(gLarry ignoreControl: 8)
		(super init: &rest)
		(self startUpd: setPri: 9)
	)
	
	(method (open)
		(self setPri: 9)
		(gLarry illegalBits: 0)
		(super open:)
	)
	
	(method (close)
		(super close:)
		(self setPri: 8)
		(gLarry observeControl: 8 -32768)
	)
)

(instance degausser of Feature
	(properties
		x 162
		y 74
		nsTop 65
		nsLeft 151
		nsBottom 84
		nsRight 173
		description {demagnetizÈr}
		sightAngle 40
		lookStr {Tv˘j demagnetizÈr, kter˝ pouûÌv·ö k p¯emaz·nÌ kazet, leûÌ na pracovnÌm stole.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(proc0_14 170 11)
				(proc0_14 170 12 67 -1 185)
			)
			(4
				(if (proc999_5 param2 2 3 4)
					(if ((Inv at: param2) state?)
						(global2 setScript: sDegaussTape 0 0)
					else
						(global2 setScript: sDegaussTape 0 param2)
					)
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

(instance drawer1 of Feature
	(properties
		x 52
		y 88
		nsTop 84
		nsLeft 37
		nsBottom 93
		nsRight 68
		description {öuplÌk}
		sightAngle 40
		approachX 57
		approachY 109
		lookStr {Vypad· jako zav¯en· z·suvka.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(global2 setScript: sOpenDrawer 0 1)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance drawer2 of Feature
	(properties
		x 99
		y 88
		nsTop 84
		nsLeft 82
		nsBottom 93
		nsRight 117
		description {öuplÌk}
		sightAngle 40
		approachX 104
		approachY 110
		lookStr {Vypad· jako zav¯en· z·suvka.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(global2 setScript: sOpenDrawer 0 2)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance drawer3 of Feature
	(properties
		x 145
		y 88
		nsTop 84
		nsLeft 129
		nsBottom 93
		nsRight 162
		description {öuplÌk}
		sightAngle 40
		approachX 151
		approachY 110
		lookStr {Vypad· to jako zav¯en· z·suvka.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(global2 setScript: sOpenDrawer 0 3)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance cabinet of Feature
	(properties
		x 98
		y 44
		nsTop 30
		nsLeft 38
		nsBottom 58
		nsRight 159
		description {sk¯ÌÚka}
		sightAngle 40
		lookStr {Nem·ö ponÏtÌ, co je uvnit¯ tÏchto sk¯ÌnÌ, protoûe jsi p¯Ìliö mal˝ na to, abys vidÏl dovnit¯.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 170 13))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance sterileBarrel of Feature
	(properties
		x 222
		y 44
		nsTop 22
		nsLeft 204
		nsBottom 66
		nsRight 240
		description {tv˘j barel steriliz·toru}
		sightAngle 40
		lookStr {Tento barel obsahuje sterilizaËnÌ roztok, kter˝ pouûÌv·ö na vöechny p¯ÌchozÌ videokazety p¯ed jejich p¯evinutÌm a rozdÏlenÌm Ëlen˘m konkurznÌho t˝mu ASHV.}
	)
	
	(method (doVerb theVerb param2 &tmp [temp0 100])
		(switch theVerb
			(3
				(proc0_10 1 83)
				(proc0_14 170 14)
			)
			(5 (proc0_14 170 15))
			(4
				(Format
					@temp0
					170
					16
					((Inv at: param2) description?)
					37
				)
				(proc0_14 @temp0)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance videoMonitor1 of Feature
	(properties
		x 29
		y 68
		nsTop 54
		nsLeft 14
		nsBottom 82
		nsRight 44
		description {videomonitor}
		sightAngle 40
		lookStr {Tento monitor pouûÌv·ö kaûd˝ den k prohlÌûenÌ p¯ÌchozÌch nahr·vek a ujiöùujeö se, ûe jsou dostateËnÏ explicitnÌ, abys je mohl p¯edat ofici·lnÌm Ëlen˘m t˝mu pro p¯ijÌmacÌ ¯ÌzenÌ.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 170 17))
			(4
				(if (proc999_5 param2 2 3 4)
					(proc0_14 170 18)
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

(instance videoMonitor2 of Feature
	(properties
		x 286
		y 168
		nsTop 148
		nsLeft 254
		nsBottom 189
		nsRight 319
		sightAngle 40
	)
	
	(method (doVerb)
		(videoMonitor1 doVerb: &rest)
	)
)

(instance drain of Feature
	(properties
		x 149
		y 1124
		z 1000
		nsTop 119
		nsLeft 133
		nsBottom 130
		nsRight 166
		description {podlahov˝ odtok}
		sightAngle 40
		lookStr {»asto m·ö pocit, ûe pr·vÏ sem smÏ¯uje tv˘j ûivot.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(proc0_14 170 19)
				(proc0_14 170 20 67 -1 185)
			)
			(5
				(proc0_14 170 21)
				(proc0_14 170 22 67 -1 20)
				(proc0_14 170 22)
				(proc0_14 170 22 67 -1 185)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance boxes of Feature
	(properties
		x 84
		y 156
		nsTop 123
		nsLeft 49
		nsBottom 189
		nsRight 120
		description {krabice}
		sightAngle 40
		lookStr {Pr·zdnÈ krabice ti jsou k niËemu.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 170 23))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance videotapes1 of Feature
	(properties
		x 10
		y 170
		nsTop 151
		nsBottom 189
		nsRight 21
		description {nÏkterÈ videokazety}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 170 24))
			(2
				(proc0_14 170 25)
				(proc0_14 170 26 67 -1 185)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance videotapes2 of Feature
	(properties
		x 116
		y 71
		nsTop 63
		nsLeft 89
		nsBottom 79
		nsRight 143
		sightAngle 40
	)
	
	(method (doVerb)
		(videotapes1 doVerb: &rest)
	)
)

(instance videotapes3 of Feature
	(properties
		x 55
		y 115
		nsTop 101
		nsLeft 6
		nsBottom 130
		nsRight 104
		sightAngle 40
	)
	
	(method (doVerb)
		(videotapes1 doVerb: &rest)
	)
)

(instance videotapes4 of Feature
	(properties
		x 169
		y 153
		nsTop 118
		nsLeft 109
		nsBottom 188
		nsRight 229
		sightAngle 40
	)
	
	(method (doVerb)
		(videotapes1 doVerb: &rest)
	)
)

(instance videotapes5 of Feature
	(properties
		x 227
		y 96
		nsTop 79
		nsLeft 204
		nsBottom 113
		nsRight 250
		sightAngle 40
	)
	
	(method (doVerb)
		(videotapes1 doVerb: &rest)
	)
)

(instance videotapes6 of Feature
	(properties
		x 304
		y 114
		nsTop 82
		nsLeft 289
		nsBottom 146
		nsRight 319
		sightAngle 40
	)
	
	(method (doVerb)
		(videotapes1 doVerb: &rest)
	)
)

(instance videotapes7 of Feature
	(properties
		x 103
		y 16
		nsTop 3
		nsLeft 41
		nsBottom 29
		nsRight 166
		sightAngle 40
	)
	
	(method (doVerb)
		(videotapes1 doVerb: &rest)
	)
)

(instance lightWest of Feature
	(properties
		x 24
		y 32
		nsTop 23
		nsLeft 8
		nsBottom 41
		nsRight 41
		description {lampa}
		sightAngle 40
		lookStr {Jen se tu tak poflakuje... jako ty, Larry!}
	)
	
	(method (onMe)
		(if (super onMe: &rest) else (lightEast onMe: &rest))
	)
)

(instance lightEast of Feature
	(properties
		x 178
		y 29
		nsTop 19
		nsLeft 160
		nsBottom 39
		nsRight 196
		sightAngle 40
	)
)

(instance dice of Feature
	(properties
		x 190
		y 127
		z 52
		nsTop 65
		nsLeft 180
		nsBottom 85
		nsRight 200
		description {chlupatÈ kostky}
		sightAngle 40
		lookStr {Tv˝m jedin˝m pokusem o v˝zdobu tvÈho pracovnÌho prostoru je polovina p·ru chlupat˝ch kostek, kterÈ ti zbyly z tvÈho Brouka z roku 74.}
	)
)

(instance eightTrack of Prop
	(properties
		x 54
		y 77
		description {tv˘j osmistop˝ p¯ehr·vaË}
		sightAngle 40
		lookStr {Na tvÈm pracovnÌm stole leûÌ tv˘j vÏrn˝ osmistop˝ magnetofon Strombug Carlton. AËkoli m·ö v poslednÌ dobÏ problÈmy se sh·nÏnÌm nov˝ch kazet, po¯·d ti to hezky hraje.}
		view 170
		cel 2
	)
	
	(method (init)
		(= local1 0)
		(super init:)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(3
				(proc0_10 5 84)
				(if (not local1)
					(= temp0
						(proc940_0
							{P¯ehr·t kterou osmistopou kazetu? }
							106
							81
							{__The Larry Song__}
							100
							81
							{ Record des Rever_}
							640
							106
							81
							{__Desmond's Theme__}
							410
							81
							{__Silas Scruemall__}
							150
							106
							81
							{___Closing Theme___}
							462
							81
							{___Hard Rock Me___}
							500
							106
							81
							{___Hard Rock You__}
							501
							81
							{____Hard Rock It____}
							502
							106
							81
							{__Michelle's Song__}
							535
							81
							{______Shill This______}
							620
							106
							81
							{______Saxy Sex______}
							345
							81
							{Na promen·dÏ}
							700
							106
							81
							{< DalöÌ obrazovka >}
							-1
							4
							70
							3
							10
							106
							81
							{< Vysunout >}
							0
							4
							95
						)
					)
				else
					(= temp0
						(proc940_0
							{P¯ehr·t kterou osmistopou kazetu?}
							106
							81
							{ A Studio Session_}
							660
							81
							{__Gettin' Some Air__}
							663
							106
							81
							{____Nasty Girlz_____}
							738
							81
							{____Whoz On Top?____}
							740
							106
							81
							{__Tramp's Casino__}
							710
							81
							{____Ivana Skate____}
							790
							106
							81
							{_____K-RAP Rap_____}
							800
							81
							{_____K-RAP Talk_____}
							801
							106
							81
							{____K-RAP Rock_____}
							802
							81
							{___Doc'll Pulliam____}
							905
							106
							81
							{__Chi Chi a Me Me__}
							910
							81
							{____Salsa This_____}
							920
							106
							81
							{< P¯edchozÌ obrazovka >}
							-1
							4
							70
							3
							10
							106
							81
							{< Vysunout >}
							0
							4
							95
						)
					)
				)
				(switch temp0
					(-1
						(= local1 (- 1 local1))
						(proc0_17 1 0 self)
					)
					(0
						(gLongSong number: 160 setLoop: -1 play:)
					)
					(else 
						(gLongSong number: temp0 setLoop: -1 play:)
					)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (cue)
		(self doVerb: 3)
	)
)

(instance funSound of Sound
	(properties)
)
